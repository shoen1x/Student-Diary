package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.room.util.CopyLock;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper {
    private final Context mContext;
    private final String mCopyFromAssetPath;
    private final File mCopyFromFile;
    private DatabaseConfiguration mDatabaseConfiguration;
    private final int mDatabaseVersion;
    private final SupportSQLiteOpenHelper mDelegate;
    private boolean mVerified;

    SQLiteCopyOpenHelper(Context context, String copyFromAssetPath, File copyFromFile, int databaseVersion, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        this.mContext = context;
        this.mCopyFromAssetPath = copyFromAssetPath;
        this.mCopyFromFile = copyFromFile;
        this.mDatabaseVersion = databaseVersion;
        this.mDelegate = supportSQLiteOpenHelper;
    }

    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    public void setWriteAheadLoggingEnabled(boolean enabled) {
        this.mDelegate.setWriteAheadLoggingEnabled(enabled);
    }

    public synchronized SupportSQLiteDatabase getWritableDatabase() {
        if (!this.mVerified) {
            verifyDatabaseFile();
            this.mVerified = true;
        }
        return this.mDelegate.getWritableDatabase();
    }

    public synchronized SupportSQLiteDatabase getReadableDatabase() {
        if (!this.mVerified) {
            verifyDatabaseFile();
            this.mVerified = true;
        }
        return this.mDelegate.getReadableDatabase();
    }

    public synchronized void close() {
        this.mDelegate.close();
        this.mVerified = false;
    }

    /* access modifiers changed from: package-private */
    public void setDatabaseConfiguration(DatabaseConfiguration databaseConfiguration) {
        this.mDatabaseConfiguration = databaseConfiguration;
    }

    private void verifyDatabaseFile() {
        String databaseName = getDatabaseName();
        File databaseFile = this.mContext.getDatabasePath(databaseName);
        DatabaseConfiguration databaseConfiguration = this.mDatabaseConfiguration;
        CopyLock copyLock = new CopyLock(databaseName, this.mContext.getFilesDir(), databaseConfiguration == null || databaseConfiguration.multiInstanceInvalidation);
        try {
            copyLock.lock();
            if (!databaseFile.exists()) {
                copyDatabaseFile(databaseFile);
                copyLock.unlock();
            } else if (this.mDatabaseConfiguration == null) {
                copyLock.unlock();
            } else {
                try {
                    int currentVersion = DBUtil.readVersion(databaseFile);
                    if (currentVersion == this.mDatabaseVersion) {
                        copyLock.unlock();
                    } else if (this.mDatabaseConfiguration.isMigrationRequired(currentVersion, this.mDatabaseVersion)) {
                        copyLock.unlock();
                    } else {
                        if (this.mContext.deleteDatabase(databaseName)) {
                            try {
                                copyDatabaseFile(databaseFile);
                            } catch (IOException e) {
                                Log.w("ROOM", "Unable to copy database file.", e);
                            }
                        } else {
                            Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                        }
                        copyLock.unlock();
                    }
                } catch (IOException e2) {
                    Log.w("ROOM", "Unable to read database version.", e2);
                    copyLock.unlock();
                }
            }
        } catch (IOException e3) {
            throw new RuntimeException("Unable to copy database file.", e3);
        } catch (Throwable th) {
            copyLock.unlock();
            throw th;
        }
    }

    private void copyDatabaseFile(File destinationFile) throws IOException {
        ReadableByteChannel input;
        if (this.mCopyFromAssetPath != null) {
            input = Channels.newChannel(this.mContext.getAssets().open(this.mCopyFromAssetPath));
        } else if (this.mCopyFromFile != null) {
            input = new FileInputStream(this.mCopyFromFile).getChannel();
        } else {
            throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
        }
        File intermediateFile = File.createTempFile("room-copy-helper", ".tmp", this.mContext.getCacheDir());
        intermediateFile.deleteOnExit();
        FileUtil.copy(input, new FileOutputStream(intermediateFile).getChannel());
        File parent = destinationFile.getParentFile();
        if (parent != null && !parent.exists() && !parent.mkdirs()) {
            throw new IOException("Failed to create directories for " + destinationFile.getAbsolutePath());
        } else if (!intermediateFile.renameTo(destinationFile)) {
            throw new IOException("Failed to move intermediate file (" + intermediateFile.getAbsolutePath() + ") to destination (" + destinationFile.getAbsolutePath() + ").");
        }
    }
}
