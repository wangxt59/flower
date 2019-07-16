package com.wang.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author cheng
 * @ClassName: ActionAspect
 * @Description:控制层切面类
 * @date 2017年9月25日 上午11:05:38
 */
@Aspect
@Component
public class ActionAspect {

    /**
     * @Title: actionAspect
     * @Description:切入点表达式
     */
//    @Pointcut("execution(public * com.wang.controller.*.*(..))")
    @Pointcut("execution(public * com.wang.controller.HelloController.aop(..))")
    public void actionAspect() {
        System.out.println("呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜 。");
    }

    /**
     * @Title: beforeMethod
     * @Description:目标方法执行之前调用
     */
    @Before("actionAspect()")
    @Order(1)
    public void beforeMethod() {
        System.out.println("目标方法执行之前调用      @Order(1)  ");
    }
    @Before("actionAspect()")
    @Order(2)
    public void beforeMethod2() {
        System.out.println("目标方法执行之前调用      @Order(2)  ");
    }

    /**
     * @Title: afterMethod
     * @Description:目标方法返回或者抛出异常之后调用
     */
    @After("actionAspect()")
    @Order(1)
    public void afterMethod() {
        System.out.println("目标方法返回或者抛出异常之后调用    @Order(1)");
    }
    @After("actionAspect()")
    @Order(2)
    public void afterMethod1() {
        System.out.println("目标方法返回或者抛出异常之后调用    @Order(2)");
    }

    /**
     * @Title: afterReturningMethod
     * @Description:目标方法返回之后调用,抛出异常时不调用
     */
//    @AfterReturning("actionAspect()")
    public void afterReturningMethod() {
        System.out.println("目标方法返回之后调用,抛出异常时不调用。。。");
    }

    /**
     * @Title: afterThrowingMethod
     * @Description:目标方法抛出异常之后调用,正常返回时不调用
     */
//    @AfterThrowing("actionAspect()")
    public void afterThrowingMethod() {
        System.out.println("目标方法抛出异常之后调用,正常返回时不调用。。。");
    }

    /**
     * @param joinPoint
     * @return
     * @throws Throwable
     * @Title: aroundMethod
     * @Description: 环绕通知
     */
//    @Around("actionAspect()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕在目标方法之前。。。");
        // 访问目标方法名称
        String methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        // 访问目标方法的参数
        Object[] paramsArr = joinPoint.getArgs();
        // 执行目标方法
        Object returnObj = joinPoint.proceed(paramsArr);
        System.out.println("执行的方法:" + methodName);
        System.out.println("环绕在目标方法之后。。。");
        return returnObj;
    }
//    @Around("actionAspect()")
//    public void message(ProceedingJoinPoint joinPoint){
//        获取目标方法所在类名称
//        String className = joinPoint.getSignature().getDeclaringTypeName();
//        System.out.println("目标方法所在类名称"+className);
//        //获取目标方法名称
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("目标方法名称"+className);
//        //获取目标方法完整名称
//        String fullMethodName = className + "." + methodName;
//        System.out.println("目标方法完整名称"+className);
//        //获取目标方法参数
//        Object[] paramsArray = joinPoint.getArgs();
//        System.out.println("目标方法参数"+paramsArray.toString());
    //以原来的参数列表执行目标方法
//            joinPoint.proceed();
//            Object returnObject = joinPoint.proceed();
//            System.out.println("以原来的参数列表执行目标方法"+className);
//            //以自定义参数列表执行目标方法
//            Object returnObject = joinPoint.proceed(paramsArray);
//            System.out.println("目标方法完整名称"+className);

//    }

}