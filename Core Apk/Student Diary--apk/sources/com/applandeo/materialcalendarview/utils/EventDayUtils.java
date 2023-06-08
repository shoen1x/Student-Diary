package com.applandeo.materialcalendarview.utils;

import com.annimon.stream.Optional;
import com.annimon.stream.Stream;
import com.annimon.stream.function.Predicate;
import com.applandeo.materialcalendarview.EventDay;
import java.util.Calendar;

public class EventDayUtils {
    public static boolean isEventDayWithLabelColor(Calendar day, CalendarProperties calendarProperties) {
        if (calendarProperties.getEventDays() != null || calendarProperties.getEventsEnabled()) {
            return Stream.of(calendarProperties.getEventDays()).anyMatch(new Predicate(day) {
                private final /* synthetic */ Calendar f$0;

                {
                    this.f$0 = r1;
                }

                public final boolean test(Object obj) {
                    return EventDayUtils.lambda$isEventDayWithLabelColor$0(this.f$0, (EventDay) obj);
                }
            });
        }
        return false;
    }

    static /* synthetic */ boolean lambda$isEventDayWithLabelColor$0(Calendar day, EventDay eventDate) {
        return eventDate.getCalendar().equals(day) && eventDate.getLabelColor() != 0;
    }

    public static Optional<EventDay> getEventDayWithLabelColor(Calendar day, CalendarProperties calendarProperties) {
        return Stream.of(calendarProperties.getEventDays()).filter(new Predicate(day) {
            private final /* synthetic */ Calendar f$0;

            {
                this.f$0 = r1;
            }

            public final boolean test(Object obj) {
                return EventDayUtils.lambda$getEventDayWithLabelColor$1(this.f$0, (EventDay) obj);
            }
        }).findFirst();
    }

    static /* synthetic */ boolean lambda$getEventDayWithLabelColor$1(Calendar day, EventDay eventDate) {
        return eventDate.getCalendar().equals(day) && eventDate.getLabelColor() != 0;
    }
}
