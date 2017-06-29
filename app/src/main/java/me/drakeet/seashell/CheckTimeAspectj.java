package me.drakeet.seashell;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
/**
 * Created by kangxu on 2017/6/29.
 */

@Aspect
public class CheckTimeAspectj {
    private static final String TAG1="CheckLeak-time(watch)";
    private static final String TAG2="CheckLeak-time(ensur)";
    private static final String TAG3="CheckLeak-time(dump)";
    private static final String TAG4="CheckLeak-time(analyz)";
    private static final String TAG5="CheckLeak-time(runAna)";
    private static final String TAG6="CheckLeak-time(sendRe)";
    private static final String TAG7="CheckLeak-time(onHeap)";
    private static final String TAG8="CheckLeak-time(execut)";
    @Pointcut("call(* com.squareup.leakcanary.RefWatcher.watch(..))" )
    public void checktime1(){}
    @Around("checktime1()")
    public Object profile(ProceedingJoinPoint pjp)throws Throwable
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
    @Pointcut("call(* com.squareup.leakcanary.RefWatcher.ensureGone(..))")
    public void checktime2(){}
    @Around("checktime2()")
    public Object profile2(ProceedingJoinPoint pjp)throws Throwable
    {
        long start=0;
        try {
            start= System.nanoTime();
            return pjp.proceed();

        }finally
        {
            long end = System.nanoTime();
            String msg = String.valueOf(end - start);
            Log.d(TAG2, msg+"ns");
        }
    }
    @Pointcut("call(* com.squareup.leakcanary.HeapDumper.dumpHeap(..))")
    public void checktime3(){}
    @Around("checktime3()")
    public Object profile3(ProceedingJoinPoint pjp)throws Throwable
    {
        long start=0;
        try {
            start= System.nanoTime();
            return pjp.proceed();

        }finally
        {
            long end = System.nanoTime();
            String msg = String.valueOf(end - start);
            Log.d(TAG3, msg+"ns");
        }
    }
    @Pointcut("call(* com.squareup.leakcanary.ServiceHeapDumpListener.analyze(..))")
    public void checktime4(){}
    @Around("checktime4()")
    public Object profile4(ProceedingJoinPoint pjp)throws Throwable
    {
        long start=0;
        try {
            start= System.nanoTime();
            return pjp.proceed();

        }finally
        {
            long end = System.nanoTime();
            String msg = String.valueOf(end - start);
            Log.d(TAG4, msg+"ns");
        }
    }
    @Pointcut("call(* com.squareup.leakcanary.internal.HeapAnalyzerService.runAnalysis(..))")
    public void checktime5(){}
    @Around("checktime5()")
    public Object profile5(ProceedingJoinPoint pjp)throws Throwable
    {
        long start=0;
        try {
            start= System.nanoTime();
            return pjp.proceed();

        }finally
        {
            long end = System.nanoTime();
            String msg = String.valueOf(end - start);
            Log.d(TAG5, msg+"ns");
        }
    }
    @Pointcut("call(* com.squareup.leakcanary.AbstractAnalysisResultService.sendResultToListener(..))")
    public void checktime6(){}
    @Around("checktime6()")
    public Object profile6(ProceedingJoinPoint pjp)throws Throwable
    {
        long start=0;
        try {
            start= System.nanoTime();
            return pjp.proceed();

        }finally
        {
            long end = System.nanoTime();
            String msg = String.valueOf(end - start);
            Log.d(TAG6, msg+"ns");
        }
    }
    @Pointcut("call(* com.squareup.leakcanary.DisplayLeakService.onHeapAnalyzed(..))")
    public void checktime7(){}
    @Around("checktime7()")
    public Object profile7(ProceedingJoinPoint pjp)throws Throwable
    {
        long start=0;
        try {
            start= System.nanoTime();
            return pjp.proceed();

        }finally
        {
            long end = System.nanoTime();
            String msg = String.valueOf(end - start);
            Log.d(TAG7, msg+"ns");
        }
    }
    @Pointcut("call(* com.squareup.leakcanary.AndroidWathchExecutor.execute(..))")
    public void checktime8(){}
    @Around("checktime8()")
    public Object profile8(ProceedingJoinPoint pjp)throws Throwable
    {
        long start=0;
        try {
            start= System.nanoTime();
            return pjp.proceed();

        }finally
        {
            long end = System.nanoTime();
            String msg = String.valueOf(end - start);
            Log.d(TAG8, msg+"ns");
        }
    }
}
