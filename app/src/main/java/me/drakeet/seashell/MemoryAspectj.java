package me.drakeet.seashell;
import android.util.Log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import com.squareup.leakcanary.DisplayLeakService;
/**
 * Created by kangxu on 2017/6/29.
 */
@Aspect
public class MemoryAspectj {
    private static String TAG1="Memory1";
    private static String TAG2="Memory2";
    private static String TAG3="Memory3";
    private static String TAG4="Memory4";
    @Pointcut("call(* com.squareup.leakcanary.LeakCanary.install(..))")
    //在LeakCanary初始化时的内存使用
    public void Mem1(){}
    @Before("Mem1()")
    public void onActivityMethodBefore1() throws Throwable {
        Runtime run=Runtime.getRuntime();
        long free=run.freeMemory();
        long total=run.totalMemory();
        long max=run.maxMemory();
        long use=total-free;
        String msg="totalMemory"+String.valueOf(total)+"B "+"freeMemory"+String.valueOf(free)+"B "
                +"maxMemory"+String.valueOf(max)+"B "+"useMemory"+String.valueOf(use)+"B";
        Log.d(TAG1,msg);
    }
    @Pointcut("execution(* me.drakeet.seashell.ui.MainActivity.onCreate(..))")
    //APP启动时的内存使用
    public void Mem2(){}
    @Before("Mem2()")
    public void onActivityMethodBefore2() throws Throwable {
        Runtime run=Runtime.getRuntime();
        long free=run.freeMemory();
        long total=run.totalMemory();
        long max=run.maxMemory();
        long use=total-free;
        String msg="totalMemory"+String.valueOf(total)+"B "+"freeMemory"+String.valueOf(free)+"B "
                +"maxMemory"+String.valueOf(max)+"B "+"useMemory"+String.valueOf(use)+"B";
        Log.d(TAG2,msg);
    }
    @Pointcut("call(* com.squareup.leakcanary.internal.HeapAnalyzerService.runAnalysis(..))")
    //leakcanary运行分析时的内存使用
    public void Mem3(){}
    @After("Mem3()")
    public void onActivityMethodBefore3() throws Throwable {
        Runtime run=Runtime.getRuntime();
        long free=run.freeMemory();
        long total=run.totalMemory();
        long max=run.maxMemory();
        long use=total-free;
        String msg="totalMemory"+String.valueOf(total)+"B "+"freeMemory"+String.valueOf(free)+"B "
                +"maxMemory"+String.valueOf(max)+"B "+"useMemory"+String.valueOf(use)+"B";
        Log.d(TAG3,msg);
    }
    @Pointcut("execution(* me.drakeet.seashell.ui.MainActivity.onDestroy(..))")
    //leakcannary开始检测时的内存使用
    public void Mem4(){}
    @Before("Mem4()")
    public void onActivityMethodBefore4() throws Throwable {
        Runtime run=Runtime.getRuntime();
        long free=run.freeMemory();
        long total=run.totalMemory();
        long max=run.maxMemory();
        long use=total-free;
        String msg="totalMemory"+String.valueOf(total)+"B "+"freeMemory"+String.valueOf(free)+"B "
                +"maxMemory"+String.valueOf(max)+"B "+"useMemory"+String.valueOf(use)+"B";
        Log.d(TAG4,msg);
    }
}
