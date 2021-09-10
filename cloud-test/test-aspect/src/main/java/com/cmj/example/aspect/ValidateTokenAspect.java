package com.cmj.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @description
 * @date 2021/9/2 7:53 下午
 */
@Aspect
@Component
@Slf4j
public class ValidateTokenAspect {

    @Pointcut(value = "@annotation(com.cmj.example.aspect.ValidateToken)")
    public void pointcut() {
    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        Method targetMethod = this.getTargetMethod(pjp);
        ValidateToken validateToken = targetMethod.getAnnotation(ValidateToken.class);

        String tokenSpel = validateToken.token();
        String appIdSpel = validateToken.appId();
        String channelIdSpel = validateToken.channelId();
        String userIdSpel = validateToken.userId();

        ExpressionParser parser = new SpelExpressionParser();
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = discoverer.getParameterNames(targetMethod);
        Object[] args = pjp.getArgs();
        EvaluationContext context = new StandardEvaluationContext();
        for (int len = 0; len < paramNames.length; len++) {
            context.setVariable(paramNames[len], args[len]);
        }

        Expression expression = parser.parseExpression(tokenSpel);
        String token = expression.getValue(context, String.class);
        expression = parser.parseExpression(appIdSpel);
        String appId = expression.getValue(context, String.class);
        expression = parser.parseExpression(channelIdSpel);
        String channelId = expression.getValue(context, String.class);
        expression = parser.parseExpression(userIdSpel);
        String userId = expression.getValue(context, String.class);


        log.info("token is {}\tappId is {}\tchannel is {}\tuserId is {}", token, appId, channelId, userId);
        return pjp.proceed();

    }

    /**
     * 获取目标方法
     *
     * @param pjp
     * @return java.lang.reflect.Method
     * @date 2021/9/2
     */
    private Method getTargetMethod(ProceedingJoinPoint pjp) {
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method agentMethod = methodSignature.getMethod();
        try {
            return pjp.getTarget().getClass().getMethod(agentMethod.getName(), agentMethod.getParameterTypes());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("获取目标方法异常");
        }
    }
}
