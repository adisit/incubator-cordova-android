package org.apache.cordova.json;

import java.util.List;
import java.util.HashMap;
import org.json.JSONArray;
import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONException;

import android.util.Log;

public class UtilJSONParser {

	private String data = null;
	private JSONObject jObject = null;
	
	public UtilJSONParser(String data) throws JSONException {
		
		this.data = data;
		jObject = new JSONObject(this.data);
	}
	
	public String getStringValueFromNodeName(String nodename) {
		
		try {
			return jObject.getString(nodename);
		} catch (JSONException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public HashMap<String, Object> parserLevelDData() {
		
		HashMap<String, Object> result = null;
		HashMap<String, Object> paramsObj = null;
		
		try {
			result = new HashMap<String, Object>();
			result.put("code", "200");
			result.put("description", "success");
			
			JSONArray jName = jObject.names();
			for(int i=0; i<jName.length(); i++) {	
				
				if(jName.getString(i).equalsIgnoreCase("parameters") || jName.getString(i).equalsIgnoreCase("info")) {
					
					try {
						JSONObject parametersObj = jObject.getJSONObject(jName.getString(i));
						JSONArray jParamsName = parametersObj.names();
						
						paramsObj = new HashMap<String, Object>();
						for(int j=0; j<jParamsName.length(); j++) {
							
							paramsObj.put(jParamsName.getString(j), parametersObj.getString(jParamsName.getString(j)));
						}
						result.put(jName.getString(i), (HashMap<String, Object>) paramsObj);
					} catch(Exception e) {
						paramsObj = new HashMap<String, Object>();
						result.put(jName.getString(i), (HashMap<String, Object>) paramsObj);
					}
					
				} else {
					result.put(jName.getString(i), jObject.getString(jName.getString(i)));
				}
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			result = new HashMap<String, Object>();
			result.put("code", "500");
			result.put("description", e.getMessage());
		}
		return result;
	}
	
	public HashMap<String, Object> parserGetPlace() {
		
		HashMap<String, Object> result = null;
		HashMap<String, Object> response = null;
		try {
			result = new HashMap<String, Object>();
			
			JSONObject jResponseObject = jObject.getJSONObject("response");
			
			result.put("code", jResponseObject.getString("status_code"));
			result.put("description", jResponseObject.getString("status_txt"));
			
			if(jResponseObject.getString("status_code").equals("200")) {
				
				if(!jResponseObject.isNull("data")) {
					
					HashMap<String, Object> data = new HashMap<String, Object>();
					JSONObject jDataObj = jResponseObject.getJSONObject("data");
					
					JSONArray jResultArr = jDataObj.getJSONArray("rows");
					List<HashMap<String, String>> result_list = new ArrayList<HashMap<String, String>>();
					for(int i=0; i<jResultArr.length(); i++) {
						
						JSONObject o = jResultArr.getJSONObject(i);
						JSONArray jName = o.names();
						
						HashMap<String, String> obj_hm = new HashMap<String, String>();
						for(int j=0; j<jName.length(); j++) {
							obj_hm.put(jName.getString(j), o.getString(jName.getString(j)));
						}
						result_list.add(obj_hm);
					}
					data.put("rows", result_list);
					result.put("data", data);
				}
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			result = new HashMap<String, Object>();
			result.put("code", "500");
			result.put("description", e.getMessage());
		}
		return result;
	}
	
	public HashMap<String, Object> parserAllLifeStyleCategory() {
		
		HashMap<String, Object> result = null;
		HashMap<String, Object> response = null;
		try {
			result = new HashMap<String, Object>();
			
			JSONObject jResponseObject = jObject.getJSONObject("response");
			
			result.put("code", jResponseObject.getString("status_code"));
			result.put("description", jResponseObject.getString("status_txt"));
			
			if(jResponseObject.getString("status_code").equals("200")) {
				
				if(!jResponseObject.isNull("data")) {
					
					HashMap<String, Object> data = new HashMap<String, Object>();
					JSONObject jDataObj = jResponseObject.getJSONObject("data");
					
					JSONArray jResultArr = jDataObj.getJSONArray("result");
					List<HashMap<String, String>> result_list = new ArrayList<HashMap<String, String>>();
					for(int i=0; i<jResultArr.length(); i++) {
						
						JSONObject o = jResultArr.getJSONObject(i);
						JSONArray jName = o.names();
						
						HashMap<String, String> obj_hm = new HashMap<String, String>();
						for(int j=0; j<jName.length(); j++) {
							
							if(jName.getString(j).equalsIgnoreCase("icon")) {
								JSONObject icn_o = o.getJSONObject(jName.getString(j));
								obj_hm.put(jName.getString(j), icn_o.getString("s37x37"));
							} else {
								obj_hm.put(jName.getString(j), o.getString(jName.getString(j)));
							}
						}
						result_list.add(obj_hm);
					}
					data.put("result", result_list);
					result.put("data", data);
				}
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			result = new HashMap<String, Object>();
			result.put("code", "500");
			result.put("description", e.getMessage());
		}
		return result;
	}
	
	public HashMap<String, Object> parserAllWeLoveShoppingCategory() {
		
		HashMap<String, Object> result = null;
		HashMap<String, Object> response = null;
		try {
			result = new HashMap<String, Object>();
			
			JSONObject jResponseObject = jObject.getJSONObject("response");
			
			result.put("code", jResponseObject.getString("status_code"));
			result.put("description", jResponseObject.getString("status_txt"));
			
			if(jResponseObject.getString("status_code").equals("200")) {
				
				if(!jResponseObject.isNull("data")) {
					
					HashMap<String, Object> data = new HashMap<String, Object>();
					JSONObject jDataObj = jResponseObject.getJSONObject("data");
					
					JSONArray jResultArr = jDataObj.getJSONArray("wls_cate");
					List<HashMap<String, String>> result_list = new ArrayList<HashMap<String, String>>();
					for(int i=0; i<jResultArr.length(); i++) {
						
						JSONObject o = jResultArr.getJSONObject(i);
						JSONArray jName = o.names();
						
						HashMap<String, String> obj_hm = new HashMap<String, String>();
						for(int j=0; j<jName.length(); j++) {
							
							if(jName.getString(j).equalsIgnoreCase("icon")) {
								JSONObject icn_o = o.getJSONObject(jName.getString(j));
								obj_hm.put(jName.getString(j), icn_o.getString("s37x37"));
							} else {
								obj_hm.put(jName.getString(j), o.getString(jName.getString(j)));
							}
						}
						result_list.add(obj_hm);
					}
					data.put("wls_cate", result_list);
					result.put("data", data);
				}
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			result = new HashMap<String, Object>();
			result.put("code", "500");
			result.put("description", e.getMessage());
		}
		return result;
	}
	
	public HashMap<String, Object> parserAllWeLoveShoppingCategory2() {
		
		HashMap<String, Object> result = null;
		HashMap<String, Object> response = null;
		try {
			result = new HashMap<String, Object>();
			
			JSONObject jResponseObject = jObject.getJSONObject("response");
			
			result.put("code", jResponseObject.getString("status_code"));
			result.put("description", jResponseObject.getString("status_txt"));
			
			if(jResponseObject.getString("status_code").equals("200")) {
				
				if(!jResponseObject.isNull("data")) {
					
					HashMap<String, Object> data = new HashMap<String, Object>();
					JSONObject jDataObj = jResponseObject.getJSONObject("data");
					JSONArray jDataName = jDataObj.names();
					
					for(int j=0; j<jDataName.length(); j++) {
						
						if(jDataName.getString(j).equalsIgnoreCase("result")) {
							
							//HashMap<String, Object> resultMapObj = null;
							HashMap<String, Object> categoryMapObj = null;
							List <HashMap<String, String>> catListObj = null;
							
							//resultMapObj = new HashMap<String, Object>();
							
							try {
								JSONObject jResultObj = jDataObj.getJSONObject(jDataName.getString(j));
								
								categoryMapObj = new HashMap<String, Object>();
								catListObj = new ArrayList<HashMap<String, String>>();
								
								JSONArray jCategoryListObject = jResultObj.getJSONArray("category");
								for(int k=0; k<jCategoryListObject.length(); k++) {
									
									JSONObject o = jCategoryListObject.getJSONObject(k);
									JSONArray jName = o.names();
									
									HashMap<String, String> obj_hm = new HashMap<String, String>();
									for(int l=0; l<jName.length(); l++) {
										
										obj_hm.put(jName.getString(l), o.getString(jName.getString(l)));
									}
									catListObj.add(obj_hm);
								}
								categoryMapObj.put("category", catListObj);
								
							} catch(Exception e) {
								
								e.printStackTrace();
								categoryMapObj = new HashMap<String, Object>();
								catListObj = new ArrayList<HashMap<String, String>>();
								categoryMapObj.put("category", catListObj);
							}
							//resultMapObj.put(jDataName.getString(j), categoryMapObj);
							
							data.put(jDataName.getString(j), categoryMapObj);
							
						} else {
							data.put(jDataName.getString(j), jDataObj.getString(jDataName.getString(j)));
						}
					}
					result.put("data", data);
				}
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			result = new HashMap<String, Object>();
			result.put("code", "500");
			result.put("description", e.getMessage());
		}
		return result;
	}
	
	public HashMap<String, Object> parserData() {
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
			
			result.put("code", jObject.getString("code"));
			result.put("description", jObject.getString("description"));
			
			if(jObject.getString("code").equals("200")) {
				
				if(!jObject.isNull("stat")) {
					
					JSONObject data_stat = jObject.getJSONObject("stat");
					if(data_stat != null) {
						
						JSONArray jName = data_stat.names();
						HashMap<String, String> obj_hm = new HashMap<String, String>();
						for(int j=0; j<jName.length(); j++) {
							obj_hm.put(jName.getString(j), data_stat.getString(jName.getString(j)));
						}
						result.put("stat", obj_hm);
					}
				}
				
				if(!jObject.isNull("paging")) {
					
					JSONObject data_stat = jObject.getJSONObject("paging");
					if(data_stat != null) {
						
						JSONArray jName = data_stat.names();
						HashMap<String, String> obj_hm = new HashMap<String, String>();
						for(int j=0; j<jName.length(); j++) {
							obj_hm.put(jName.getString(j), data_stat.getString(jName.getString(j)));
						}
						result.put("paging", obj_hm);
					}
					
				}
				
				if(!jObject.isNull("filters")) {
					
					try {
						
						JSONObject data_obj = jObject.getJSONObject("filters");
						JSONArray data_list = data_obj.getJSONArray("item");
						Log.v("item", String.valueOf(data_list.length()));
						List<HashMap<String, String>> obj_list = new ArrayList<HashMap<String, String>>();
						for(int i=0; i < data_list.length(); i++) {
							
							JSONObject o = data_list.getJSONObject(i);
							HashMap<String, String> obj_hm = new HashMap<String, String>();
							
							JSONArray jName = o.names();
							for(int j=0; j<jName.length(); j++) {
								obj_hm.put(jName.getString(j), o.getString(jName.getString(j)));
							}
							obj_list.add(obj_hm);
						}
						result.put("filters", obj_list);
						
					} catch(JSONException e) {
						
					}
					
				}
				
				if(!jObject.isNull("datas")) {
					
					JSONObject data_obj = jObject.getJSONObject("datas");
					JSONArray data_list = data_obj.getJSONArray("data");
					
					List<HashMap<String, String>> obj_list = new ArrayList<HashMap<String, String>>();
					for(int i=0; i < data_list.length(); i++) {
						
						JSONObject o = data_list.getJSONObject(i);
						HashMap<String, String> obj_hm = new HashMap<String, String>();
						
						JSONArray jName = o.names();
						for(int j=0; j<jName.length(); j++) {
							obj_hm.put(jName.getString(j), o.getString(jName.getString(j)));
						}
						obj_list.add(obj_hm);
					}
					result.put("data", obj_list);
				}
				
				if(!jObject.isNull("data")) {
					
					JSONArray data_list = jObject.getJSONArray("data");
					List<HashMap<String, String>> obj_list = new ArrayList<HashMap<String, String>>();
					for(int i=0; i < data_list.length(); i++) {
						
						JSONObject o = data_list.getJSONObject(i);
						HashMap<String, String> obj_hm = new HashMap<String, String>();
						
						JSONArray jName = o.names();
						for(int j=0; j<jName.length(); j++) {
							obj_hm.put(jName.getString(j), o.getString(jName.getString(j)));
						}
						obj_list.add(obj_hm);
					}
					result.put("data", obj_list);
				}
				
			}
			
		} catch (JSONException e) {

			e.printStackTrace();
			result.put("code", "500");
			result.put("description", e.getMessage());
		}
		
		return result;
	}
	
}
