package me.drakeet.seashell;
import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
/**
 * Created by kangxu on 2017/6/29.
 */
@Aspect
public class TimeAspectj {
    private static final String TAG1="install-time1";
    private static final String TAG2="install-time2";
    @Pointcut("call(* com.squareup.leakcanary.AndroidRefWatcherBuilder.buildAndInstall(..))")
    public void time1(){}
    @Around("time1()")
    public Object profile1(ProceedingJoinPoint pjp)throws Throwable
    {
        long start=0;
        try {
            start= System.nanoTime();
            return pjp.proceed();

        }finally
        {
            long end = System.nanoTime();
            String msg = String.valueOf(end - start);
            Log.d(TAG1, msg+"ns");
        }
    }
    @Pointcut("call(* com.squareup.leakcanary.LeakCanary.install(..))")
    public void time2(){}
    @Around("time2()")
    public Object profile2(ProceedingJoinPoint pjp)throws Throwable
    {
        long start=0;
        try {
            start= System.currentTimeMillis();
            return pjp.proceed();

        }finally
        {
            long end = System.nanoTime();
            String msg = String.valueOf(end - start);
            Log.d(TAG2, msg+"ns");
        }
    }


}
