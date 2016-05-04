package com.coolweather.app.util;

/*HttpUtil类中使用到了 HttpCallbackListener接口来回调服务返回的结果，因此我们还需
 要在 util包下添加这个接口，*/
public interface HttpCallbackListener {
	void onFinish(String response);

	void onError(Exception e);
}
