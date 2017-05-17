package org.kyanagimoto.flume.interceptor;

import java.util.*;
import org.apache.flume.interceptor.Interceptor;
import org.apache.flume.Event;
import org.apache.flume.Context;

/**
 * Created by koichi.yanagimoto on 2017/05/17.
 */

public class PidInterceptor implements Interceptor {
    @Override
    public void initialize() {}

    @Override
    public Event intercept(Event event) {
        Map<String, String> headers = event.getHeaders();
        headers.put("flumePid", java.lang.management.ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
        return event;
    }

    @Override
    public List<Event> intercept(List<Event> events) {
        for (Event event:events) {
            intercept(event);
        }
        return events;
    }

    @Override
    public void close() {}

    public static class Builder implements Interceptor.Builder {

        @Override
        public Interceptor build() {
            return new PidInterceptor();
        }

        @Override
        public void configure(Context context) {}
    }
}