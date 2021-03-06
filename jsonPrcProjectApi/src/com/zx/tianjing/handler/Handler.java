package com.zx.tianjing.handler;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Error;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;
import com.thetransactioncompany.jsonrpc2.server.MessageContext;
import com.thetransactioncompany.jsonrpc2.server.RequestHandler;

import com.zx.tianjing.bean.CategoryModel;
import com.zx.tianjing.bean.FestivalModel;
import com.zx.tianjing.bean.HoreModel;
import com.zx.tianjing.bean.ShortModel;
import com.zx.tianjing.bean.VersionModel;
import com.zx.tianjing.dao.CategoryDao;
import com.zx.tianjing.dao.HostManagementDao;
import com.zx.tianjing.dao.HouseHoldDao;
import com.zx.tianjing.dao.LarumInfoDao;
import com.zx.tianjing.dao.PayInfoDao;
import com.zx.tianjing.dao.PaymentManagementDao;
import com.zx.tianjing.dao.ShortDao;
import com.zx.tianjing.dao.VersionDao;


public class Handler implements RequestHandler {
	ShortDao shortDao = new ShortDao();
	CategoryDao categoryDao = new CategoryDao();
	VersionDao versionDao=new VersionDao();
	HostManagementDao hostManagementDao=new HostManagementDao();	
	LarumInfoDao larumInfoDao=new LarumInfoDao();
	PaymentManagementDao paymentManagementDao=new PaymentManagementDao();
	PayInfoDao payInfoDao = new PayInfoDao();
	HouseHoldDao houseHoldDao = new HouseHoldDao();
	Gson gson = new Gson();
	Map<String, String> methodMap = new HashMap<String, String>();
	//@Override
	public String[] handledRequests() {
		return new String[] { "getShortMessage", "uploadShortMessageStatics",
				"getCategoryList", "getQueryMenberList", "getFestivalCategory" ,"getHore",
				"findAllVersion","hostManagementStateY","hostManagementStateN","LarumInfoState","paymentStateOff","paymentStateOpen",
				"findByHouseList","findByPayList","findByPayManList","findByPayManNow"};

	}

	//@Override
	public JSONRPC2Response process(JSONRPC2Request req, MessageContext ctx) {

		methodMap.put("getShortMessage", "getShortMessage");
		methodMap.put("uploadShortMessageStatics", "uploadShortMessageStatics");
		methodMap.put("getCategoryList", "getCategoryList");
		methodMap.put("getQueryMenberList", "getQueryMenberList");
		methodMap.put("getFestivalCategory", "getFestivalCategory");
		methodMap.put("getHore", "getHore");
		methodMap.put("findAllVersion", "findAllVersion");
		methodMap.put("hostManagementStateY", "hostManagementStateY");
		methodMap.put("hostManagementStateN", "hostManagementStateN");
		methodMap.put("LarumInfoState","LarumInfoState");
		methodMap.put("paymentStateOff", "paymentStateOff");
		methodMap.put("paymentStateOpen", "paymentStateOpen");
		methodMap.put("findByHouseList","findByHouseList");
		methodMap.put("findByPayList","findByPayList");
		methodMap.put("findByPayManList","findByPayManList");
		methodMap.put("findByPayManNow","findByPayManNow");
		Map<?, ?> map = new HashMap<Object, Object>();
		map = (Map<?, ?>) req.getParams();
		if (methodMap.get(req.getMethod()).equals("getQueryMenberList")) {
			String keyword = null;
			if (null != map.get("keyword")) {
				System.out.println(map.get("keyword"));
				keyword= (String) map.get("keyword");			
			}
			int maxMsgid = 0;
			if (null != map.get("maxMsgid")) {
				maxMsgid = Integer.parseInt(map.get("maxMsgid").toString());
			}
			int categoryid = 0;
			if (null != map.get("categoryid")) {
				categoryid = Integer.parseInt(map.get("categoryid").toString());
			}
			int festivagid = 0;
			if (null != map.get("festivagid")) {
				festivagid = Integer.parseInt(map.get("festivagid").toString());
			}
			
			List<ShortModel> shortlist = shortDao.getQueryMenberList(maxMsgid,
					categoryid, festivagid, keyword);
			return new JSONRPC2Response(gson.toJson(shortlist), req.getID());
		} 
				
		else if (methodMap.get(req.getMethod()).equals("getCategoryList")) {
			List<CategoryModel> categorylist = categoryDao.getCategoryList();
			return new JSONRPC2Response(gson.toJson(categorylist), req.getID());
		}
				
/*
		 else if (methodMap.get(req.getMethod()).equals("getHore")) {
			 System.out.println("#########22222222222222");
				List<VersionModel> list = categoryDao.getHore();
				return new JSONRPC2Response(gson.toJson(list), req.getID());
			}
		*/
		
		else if (methodMap.get(req.getMethod()).equals("getFestivalCategory")) {
			System.out.println("#########333333333333333");
			List<FestivalModel> Festivallist = categoryDao
					.getFestivalCategory();
			return new JSONRPC2Response(gson.toJson(Festivallist), req.getID());
		}

		else if (methodMap.get(req.getMethod()).equals("getShortMessage")) {
			int maxMsgid = 0;
			if (null != map.get("maxMsgid")) {
				maxMsgid = Integer.parseInt(map.get("maxMsgid").toString());
			}
			int categoryid = 0;
			if (null != map.get("categoryid")) {
				categoryid = Integer.parseInt(map.get("categoryid").toString());
			}
			int festivagid = 0;
			if (null != map.get("festivagid")) {
				festivagid = Integer.parseInt(map.get("festivagid").toString());
			}
			List<ShortModel> shortlist = categoryDao.getShortMessage(maxMsgid,
					categoryid, festivagid);
			return new JSONRPC2Response(gson.toJson(shortlist), req.getID());
		}

		
		else if (methodMap.get(req.getMethod()).equals("uploadShortMessageStatics")) {
			String msgid = null;
			int totalsend = 0;
			if (null != map.get("msgid")) {
				msgid = map.get("msgid").toString();
			}
			if (null != map.get("totalsend")) {
				totalsend = Integer.parseInt(map.get("totalsend").toString());
			}

			boolean bool = shortDao.uploadShortMessageStatics(msgid, totalsend);
			return new JSONRPC2Response(gson.toJson(bool), req.getID());
		}	
	//==================================王芙蓉=========================================//	
			
		//软件版本升级（王芙蓉）
		 else if (methodMap.get(req.getMethod()).equals("findAllVersion")) {
			List<VersionModel> versionlist = versionDao.findAllVersion();
			return new JSONRPC2Response(gson.toJson(versionlist), req.getID());
			
			//主机布放      int id,String state（王芙蓉）
		}else if (methodMap.get(req.getMethod()).equals("hostManagementStateY")) {
			int id=0;
			String state=null;
			if(null != map.get("id")) {
				id = Integer.valueOf(map.get("id").toString());
			}
			if(null!=map.get("state")){
				state=map.get("state").toString();
			}
			String flag = hostManagementDao.hostManagementStateY(id, state);
			return new JSONRPC2Response(gson.toJson(flag), req.getID());
			
			//主机撤防（王芙蓉）
		}else if (methodMap.get(req.getMethod()).equals("hostManagementStateN")) {
			int id=0;
			String state=null;
			if(null != map.get("id")) {
				id = Integer.valueOf(map.get("id").toString());
			}
			if(null!=map.get("state")){
				state=map.get("state").toString();
			}
			String flag = hostManagementDao.hostManagementStateN(id, state);
			return new JSONRPC2Response(gson.toJson(flag), req.getID());
			
			//警报及紧急呼叫（王芙蓉）
		}else if (methodMap.get(req.getMethod()).equals("LarumInfoState")) {
			int L_ID=0;
			String L_Type=null;
			
			if(null != map.get("L_ID")) {
				L_ID = Integer.valueOf(map.get("L_ID").toString());
			}
			if(null!=map.get("L_Type")){
				L_Type=map.get("L_Type").toString();
			}
			String flag = larumInfoDao.LarumInfoState(L_ID, L_Type);
			return new JSONRPC2Response(gson.toJson(flag), req.getID());
			
			//paymentStateOff欠费关断应用（王芙蓉）
		}else if (methodMap.get(req.getMethod()).equals("paymentStateOff")) {
			int p_no=0;
						
			if(null != map.get("p_no")) {
				p_no = Integer.valueOf(map.get("p_no").toString());
			}
			
			Map<String, Object> flag = paymentManagementDao.paymentStateOff(p_no);
			return new JSONRPC2Response(gson.toJson(flag), req.getID());
			
			//欠费关断应用 ：返回欠费主机信息列表（王芙蓉）
		}	else if (methodMap.get(req.getMethod()).equals("paymentStateOpen")) {
			int p_no=0;
						
			if(null != map.get("p_no")) {
				p_no = Integer.valueOf(map.get("p_no").toString());
			}
			
			List list = paymentManagementDao.paymentStateOpen(p_no);
			return new JSONRPC2Response(gson.toJson(list), req.getID());
		}	
		//==============================桑治=============================================//	
				
				else if (methodMap.get(req.getMethod()).equals("findByPayList")) {
					int id=0;
					if(null != map.get("pay_no")) {
						id = Integer.valueOf(map.get("pay_no").toString());
					}
					Map<String, Object> payMap = payInfoDao.findByPayList(id);
					return new JSONRPC2Response(gson.toJson(payMap), req.getID());
				}
				else if (methodMap.get(req.getMethod()).equals("findByHouseList")) {
					String id="";
					if(null != map.get("h_no")) {
						id = map.get("h_no").toString();
					}
					Map<String, Object> houseMap = houseHoldDao.findByHouseList(id,"");
					return new JSONRPC2Response(gson.toJson(houseMap), req.getID());
				}
				else if (methodMap.get(req.getMethod()).equals("findByPayManList")) {
					int id=0;
					if(null != map.get("p_no")) {
						id = Integer.valueOf(map.get("p_no").toString());
					}
					Map<String, Object> managementMap = paymentManagementDao.findByPayManList(id);
					return new JSONRPC2Response(gson.toJson(managementMap), req.getID());
				}
				else if (methodMap.get(req.getMethod()).equals("findByPayManNow")) {
					int id=0;
					if(null != map.get("p_no")) {
						id = Integer.valueOf(map.get("p_no").toString());
					}
					Map<String, Object> managementMap = paymentManagementDao.findByPayManNow(String.valueOf(id));
					return new JSONRPC2Response(gson.toJson(managementMap), req.getID());
				}
				//桑治 ----------------------------------------------------------------------
		else {
			return new JSONRPC2Response(JSONRPC2Error.METHOD_NOT_FOUND,
					req.getID());
		}
	}
}
