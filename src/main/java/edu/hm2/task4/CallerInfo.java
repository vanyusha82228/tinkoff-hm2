package edu.hm2.task4;

public class CallerInfo {
    private static final String UNKNOWN = "Unknown";

    private CallerInfo() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();

        if (stackTrace.length >= 2) {
            StackTraceElement caller = stackTrace[1];
            String className = caller.getClassName();
            String methodName = caller.getMethodName();
            return new CallingInfo(className, methodName);
        } else {
            return new CallingInfo(UNKNOWN, UNKNOWN);
        }
    }

}
