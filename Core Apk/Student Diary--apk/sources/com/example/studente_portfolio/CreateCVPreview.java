package com.example.studente_portfolio;

import android.app.Activity;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintJob;
import android.print.PrintManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class CreateCVPreview extends AppCompatActivity {
    private static final String TAG = "TAG";
    String aboutme;
    String address;
    String compdesc;
    String comploc;
    String compname;
    String compposition;
    String educdesc;
    String educlvl;
    String educname;
    String email;
    private FirebaseFirestore fstore;
    String fullname;
    String languages;
    private FirebaseAuth mAuth;
    String phone;
    String skills;
    FirebaseUser user;
    String userID;
    WebView webView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_create_c_v_preview);
        this.webView = (WebView) findViewById(R.id.webView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarcvview);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle((CharSequence) null);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CreateCVPreview.this.finish();
                CreateCVPreview.this.overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
            }
        });
        this.mAuth = FirebaseAuth.getInstance();
        this.fstore = FirebaseFirestore.getInstance();
        this.user = FirebaseAuth.getInstance().getCurrentUser();
        this.userID = this.mAuth.getCurrentUser().getUid();
        this.fstore.collection("resume").document(this.user.getUid()).addSnapshotListener((Activity) this, (EventListener<DocumentSnapshot>) new EventListener<DocumentSnapshot>() {
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                Log.d(CreateCVPreview.TAG, "Fetched data id of  " + documentSnapshot.getString("fname"));
                CreateCVPreview.this.fullname = documentSnapshot.getString("fullname");
                CreateCVPreview.this.phone = documentSnapshot.getString("phone");
                CreateCVPreview.this.skills = documentSnapshot.getString("skills");
                CreateCVPreview.this.email = documentSnapshot.getString("email");
                CreateCVPreview.this.address = documentSnapshot.getString("address");
                CreateCVPreview.this.languages = documentSnapshot.getString("languages");
                CreateCVPreview.this.compname = documentSnapshot.getString("compname");
                CreateCVPreview.this.comploc = documentSnapshot.getString("comploc");
                CreateCVPreview.this.compposition = documentSnapshot.getString("compposition");
                CreateCVPreview.this.compdesc = documentSnapshot.getString("compdesc");
                CreateCVPreview.this.educname = documentSnapshot.getString("educname");
                CreateCVPreview.this.educlvl = documentSnapshot.getString("educlvl");
                CreateCVPreview.this.educdesc = documentSnapshot.getString("educdesc");
                CreateCVPreview.this.aboutme = documentSnapshot.getString("aboutme");
            }
        });
        ((Button) findViewById(R.id.displaycvbtn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CreateCVPreview.this.webView.setVisibility(0);
                CreateCVPreview.this.onClickPrint();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() != R.id.print_menu) {
                    return false;
                }
                CreateCVPreview createCVPreview = CreateCVPreview.this;
                createCVPreview.createWebPrintJob(createCVPreview.webView);
                return false;
            }
        });
    }

    /* access modifiers changed from: private */
    public void onClickPrint() {
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append(String.format("<!DOCTYPE html>\n<html>\n<head>\n<title>Resume</title>\n<meta charset=UTF-8>\n<link rel=\"shortcut icon\" href=https://ssl.gstatic.com/docs/documents/images/kix-favicon6.ico>\n<style type=text/css>body{font-family:arial,sans,sans-serif;margin:0}iframe{border:0;frameborder:0;height:100%%;width:100%%}#header,#footer{background:#f0f0f0;padding:10px 10px}#header{border-bottom:1px #ccc solid}#footer{border-top:1px #ccc solid;border-bottom:1px #ccc solid;font-size:13}#contents{margin:6px}.dash{padding:0 6px}</style>\n</head>\n<body>\n<div id=contents>\n<style type=text/css>@import url('https://themes.googleusercontent.com/fonts/css?kit=xTOoZr6X-i3kNg7pYrzMsnEzyYBuwf3lO_Sc3Mw9RUVbV0WvE1cEyAoIq5yYZlSc');ol{margin:0;padding:0}table td,table th{padding:0}.c26{border-right-style:solid;padding:3.6pt 3.6pt 3.6pt 3.6pt;border-bottom-color:#fff;border-top-width:0;border-right-width:0;border-left-color:#fff;vertical-align:top;border-right-color:#fff;border-left-width:0;border-top-style:solid;border-left-style:solid;border-bottom-width:0;width:176.3pt;border-top-color:#fff;border-bottom-style:solid}.c4{border-right-style:solid;padding:5pt 5pt 5pt 5pt;border-bottom-color:#fff;border-top-width:0;border-right-width:0;border-left-color:#fff;vertical-align:top;border-right-color:#fff;border-left-width:0;border-top-style:solid;border-left-style:solid;border-bottom-width:0;width:327.7pt;border-top-color:#fff;border-bottom-style:solid}.c16{color:#000;font-weight:700;text-decoration:none;vertical-align:baseline;font-size:12pt;font-family:\"Raleway\";font-style:normal}.c7{color:#000;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:10pt;font-family:\"Lato\";font-style:normal}.c13{color:#000;font-weight:700;text-decoration:none;vertical-align:baseline;font-size:10pt;font-family:\"Lato\";font-style:normal}.c1{color:#666;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:9pt;font-family:\"Lato\";font-style:normal}.c19{color:#000;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:6pt;font-family:\"Lato\";font-style:normal}.c20{color:#f2511b;font-weight:700;text-decoration:none;vertical-align:baseline;font-size:16pt;font-family:\"Raleway\";font-style:normal}.c6{padding-top:0;padding-bottom:0;line-height:1.0;text-align:left}.c32{padding-top:5pt;padding-bottom:0;line-height:1.15;text-align:left}.c0{padding-top:10pt;padding-bottom:0;line-height:1.0;text-align:left}.c22{padding-top:5pt;padding-bottom:0;line-height:1.0;text-align:left}.c10{color:#d44500;text-decoration:none;vertical-align:baseline;font-style:normal}.c2{padding-top:0;padding-bottom:0;line-height:1.15;text-align:left}.c33{padding-top:3pt;padding-bottom:0;line-height:1.0;text-align:left}.c9{padding-top:4pt;padding-bottom:0;line-height:1.15;text-align:left}.c23{border-spacing:0;border-collapse:collapse;margin:0 auto}.c30{color:#000;text-decoration:none;vertical-align:baseline;font-style:normal}.c3{padding-top:6pt;padding-bottom:0;line-height:1.15;text-align:left}.c14{padding-top:16pt;padding-bottom:0;line-height:1.15;text-align:left}.c28{padding-top:6pt;padding-bottom:0;line-height:1.0;text-align:left}.c18{font-size:9pt;font-family:\"Lato\";font-weight:400}.c24{font-size:14pt;font-family:\"Lato\";font-weight:700}.c8{font-size:10pt;font-family:\"Lato\";font-weight:400}.c5{font-size:11pt;font-family:\"Lato\";font-weight:400}.c31{background-color:#fff;max-width:504pt;padding:36pt 54pt 36pt 54pt}.c35{font-weight:700;font-size:24pt;font-family:\"Raleway\"}.c11{orphans:2;widows:2;height:11pt}.c21{height:auto}.c15{height:auto}.c27{height:auto}.c34{height:auto}.c29{height:auto}.c25{font-size:10pt}.c12{page-break-after:avoid}.c17{height:265pt}.title{padding-top:6pt;color:#000;font-weight:700;font-size:24pt;padding-bottom:0;font-family:\"Raleway\";line-height:1.0;page-break-after:avoid;orphans:2;widows:2;text-align:left}.subtitle{padding-top:3pt;color:#f2511b;font-weight:700;font-size:16pt;padding-bottom:0;font-family:\"Raleway\";line-height:1.0;page-break-after:avoid;orphans:2;widows:2;text-align:left}li{color:#000;font-size:11pt;font-family:\"Lato\"}p{margin:0;color:#000;font-size:11pt;font-family:\"Lato\"}h1{padding-top:4pt;color:#000;font-weight:700;font-size:12pt;padding-bottom:0;font-family:\"Raleway\";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h2{padding-top:6pt;color:#000;font-weight:700;font-size:11pt;padding-bottom:0;font-family:\"Lato\";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h3{padding-top:6pt;color:#666;font-size:9pt;padding-bottom:0;font-family:\"Lato\";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h4{padding-top:8pt;-webkit-text-decoration-skip:none;color:#666;text-decoration:underline;font-size:11pt;padding-bottom:0;line-height:1.15;page-break-after:avoid;text-decoration-skip-ink:none;font-family:\"Trebuchet MS\";orphans:2;widows:2;text-align:left}h5{padding-top:8pt;color:#666;font-size:11pt;padding-bottom:0;font-family:\"Trebuchet MS\";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h6{padding-top:8pt;color:#666;font-size:11pt;padding-bottom:0;font-family:\"Trebuchet MS\";line-height:1.15;page-break-after:avoid;font-style:italic;orphans:2;widows:2;text-align:left}</style>\n<p class=\"c2 c29\"><span class=c19></span></p>\n<a id=t.b7144d62fc47a2bfcf177a3c3dd72df0e868051e></a>\n<a id=t.0></a>\n<table class=c23>\n            <tbody>\n                <tr class=\"c21\">\n                    <td class=\"c26\" colspan=\"1\" rowspan=\"1\">\n                        <p class=\"c6 c12 title\" id=\"h.4prkjmzco10w\"><span>%s</span></p>\n                        <p class=\"c33 subtitle\" id=\"h.o2iwx3vdck7p\"><span class=\"c20\">%s</span></p>\n                    </td>\n                    <td class=\"c4\" colspan=\"1\" rowspan=\"1\">\n                        <p class=\"c6\"><span style=\"overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 418.00px; height: 2.67px;\"><img alt=\"\" src=\"https://lh4.googleusercontent.com/j7t3_XjsJ1PHIrgcWuJOWmQ2fFs9q-TT_LNTDfAXGnVu49aapNgutWcfK1k7pPzGtsu9lOvPynvLW07b_KwpVV0ituspJAXOQ_IBZyN087cqGsXawUahO2qDRCQZ8-qq4esAcP7M\" style=\"width: 418.00px; height: 2.67px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);\" title=\"horizontal line\"></span></p>\n                        <h1 class=\"c3\" id=\"h.lf5wiiqsu4ub\"><span>%s</span></h1>\n                        <p class=\"c6\"><span class=\"c7\">%s</span></p>\n                        <p class=\"c6\"><span class=\"c25\">%s</span></p>\n                        <p class=\"c0\"><span class=\"c10 c8\">%s</span></p>\n                        <p class=\"c6\"><span class=\"c8 c10\">%s</span></p>\n                    </td>\n                </tr>", new Object[]{this.fullname, this.skills, this.aboutme, this.address, "-----------------------", this.phone, this.email}));
        htmlContent.append(String.format("\n                <tr class=\"c27\">\n                    <td class=\"c26\" colspan=\"1\" rowspan=\"1\">\n                        <p class=\"c6\"><span class=\"c24\">ㅡ</span></p>\n                        <h1 class=\"c9\" id=\"h.61e3cm1p1fln\"><span class=\"c16\">skills</span></h1></td>\n                    <td class=\"c4\" colspan=\"1\" rowspan=\"1\">\n                        <p class=\"c2\"><span style=\"overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 418.00px; height: 2.67px;\"><img alt=\"\" src=\"https://lh3.googleusercontent.com/n8bZfGajkthDbPpbjeiRJ4w7rNUmj1iFxdZKCHUOVnfH9FgHVt5EBo3vOYIIoE3augYQ_DCZJUzdlStyJ5RaldVrSG36sTE0CjIot2qaiJ3YRyr2i87bt9Y9d0ngdseS9PpG0HzM\" style=\"width: 418.00px; height: 2.67px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);\" title=\"horizontal line\"></span></p>\n                        <p class=\"c3\"><span class=\"c7\">%s</span></p>\n                    </td>\n                </tr>", new Object[]{this.skills}));
        htmlContent.append(String.format("\n                <tr class=\"c27\">\n                    <td class=\"c26\" colspan=\"1\" rowspan=\"1\">\n                        <p class=\"c6\"><span class=\"c24\">ㅡ</span></p>\n                        <h1 class=\"c9\" id=\"h.61e3cm1p1fln\"><span class=\"c16\">Languages</span></h1></td>\n                    <td class=\"c4\" colspan=\"1\" rowspan=\"1\">\n                        <p class=\"c2\"><span style=\"overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 418.00px; height: 2.67px;\"><img alt=\"\" src=\"https://lh3.googleusercontent.com/n8bZfGajkthDbPpbjeiRJ4w7rNUmj1iFxdZKCHUOVnfH9FgHVt5EBo3vOYIIoE3augYQ_DCZJUzdlStyJ5RaldVrSG36sTE0CjIot2qaiJ3YRyr2i87bt9Y9d0ngdseS9PpG0HzM\" style=\"width: 418.00px; height: 2.67px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);\" title=\"horizontal line\"></span></p>\n                        <p class=\"c3\"><span class=\"c7\">%s</span></p>\n                    </td>\n                </tr>", new Object[]{this.languages}));
        htmlContent.append("\n                <tr class=\"c15\">\n                    <td class=\"c26\" colspan=\"1\" rowspan=\"1\">\n                        <p class=\"c6\"><span class=\"c24\">ㅡ</span></p>\n                        <h1 class=\"c9\" id=\"h.tk538brb1kdf\"><span class=\"c16\">Education</span></h1></td>\n                    <td class=\"c4\" colspan=\"1\" rowspan=\"1\">\n");
        Object[] objArr = new Object[5];
        String str = "c3";
        objArr[0] = 1 != 0 ? str : "c14";
        objArr[1] = this.educname;
        objArr[2] = this.educlvl;
        objArr[3] = "-----------------------";
        objArr[4] = this.educdesc;
        htmlContent.append(String.format("<h2 class=\"%s\" id=\"h.u3uy0857ab2n\"><span class=\"c5\">%s </span><span class=\"c30 c5\">/ %s</span></h2>\n                        <h3 class=\"c2\" id=\"h.re1qtuma0rpm\"><span class=\"c1\">%s</span></h3>\n                        <p class=\"c32\"><span class=\"c7\">%s</span></p>\n", objArr));
        htmlContent.append("</td>\n                </tr>");
        htmlContent.append("\n                <tr class=\"c15\">\n                    <td class=\"c26\" colspan=\"1\" rowspan=\"1\">\n                        <p class=\"c6\"><span class=\"c24\">ㅡ</span></p>\n                        <h1 class=\"c9\" id=\"h.tk538brb1kdf\"><span class=\"c16\">Experience</span></h1></td>\n                    <td class=\"c4\" colspan=\"1\" rowspan=\"1\">\n");
        Object[] objArr2 = new Object[5];
        if (0 == 0) {
            str = "c14";
        }
        objArr2[0] = str;
        objArr2[1] = this.compname;
        objArr2[2] = this.comploc;
        objArr2[3] = this.compposition;
        objArr2[4] = this.compdesc;
        htmlContent.append(String.format("<h2 class=\"%s\" id=\"h.u3uy0857ab2n\"><span class=\"c5\">%s </span><span class=\"c30 c5\">/ %s</span></h2>\n                        <h3 class=\"c2\" id=\"h.re1qtuma0rpm\"><span class=\"c1\">%s</span></h3>\n                        <p class=\"c32\"><span class=\"c7\">%s</span></p>\n", objArr2));
        htmlContent.append("</td>\n                </tr>");
        htmlContent.append("</tbody>\n</table>\n<p class=\"c2 c11\"><span class=\"c30 c5\"></span></p>\n</div>\n</body>\n</html>");
        this.webView.loadDataWithBaseURL((String) null, htmlContent.toString(), "text/html", "utf-8", (String) null);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.print_menu, menu);
        return true;
    }

    /* access modifiers changed from: private */
    public void createWebPrintJob(WebView webView2) {
        PrintJob print = ((PrintManager) getSystemService("print")).print("Shoenix Document", webView2.createPrintDocumentAdapter(), new PrintAttributes.Builder().build());
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
    }
}
