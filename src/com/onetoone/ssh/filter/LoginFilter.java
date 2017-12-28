package com.onetoone.ssh.filter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * µÇÂ¼À¹½ØÆ÷
 * @author wanghaixue
 *
 */
public class LoginFilter extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invoker) throws Exception {
		Object myself = ActionContext.getContext().getSession().get("myself");
		if (myself == null){
			return "login";
		}
		return invoker.invoke();
	}

}
