package com.nnbee.core.util;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;

public class ShortUrlUtil {
	private static String sina_api_url = PropertyUtil.get("sina_short_url_api");
	private static Logger logger = LoggerFactory.getLogger(ShortUrlUtil.class);
	
	public static String getSinaShortUtl(String url) {
		if (sina_api_url == null) {
			logger.error("sina_api_url is null。");
			return null;
		}
		
		try {
			url = URLEncoder.encode(url, "utf-8");
			String requestUrl = sina_api_url + url;
			String result = HttpUtil.get(requestUrl);
			if (result == null) {
				logger.info("getSinaShortUtl result is null");
				return null;
			}
			logger.info("getSinaShortUtl result = {}", result);
			JSONArray array = new JSONArray(result);
			JSONObject object = array.getJSONObject(0);
			String url_short = object.getString("url_short");
			return url_short;
		} catch (JSONException e) {
			logger.info("getSinaShortUtl JSONException = {}", e);
			return null;
		}catch (Exception e) {
			logger.info("getSinaShortUtl error = {}", e);
			return null;
		}
	}
}
