package com.easycodebox.common.json;

import com.easycodebox.common.lang.Dates;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;

import java.util.Date;

/**
 * @author WangXiaoJin
 * 
 */
public class DateJsonBeanProcessor  implements JsonBeanProcessor {

	private String dateFormat = Dates.DATETIME_FMT_STR;
	
	public DateJsonBeanProcessor() {
		
	}

    public DateJsonBeanProcessor(String dateFormat) {
       this.dateFormat = dateFormat;
    }
    
    public JSONObject processBean( Object bean, JsonConfig jsonConfig ) {
      JSONObject jsonObject;
      if( bean instanceof java.sql.Date ){
         bean = new Date( ((java.sql.Date) bean).getTime() );
      }
      if( bean instanceof Date ){
         jsonObject = new JSONObject()
     					.element("date", 
 							Dates.format((Date)bean, dateFormat));
      }else{
         jsonObject = new JSONObject( true );
      }
      return jsonObject;
   }
}
