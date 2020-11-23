package com.ibm.issue.pojo;

import org.springframework.beans.factory.annotation.Value;

public class EmailMessage {
	
    @Value("${spring.mail.username}")
    private String mailFrom;
    
    private String mailTo;
    
	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
    
	
	public static String getMessage(String need) {
		String url = "1.png";
		String message = "<div id=\"qm_con_body\"><div id=\"mailContentContainer\" class=\"qmbox qm_con_body_content qqmail_webmail_only\" style=\"\"><div style=\"text-align:center;background:#f1f4f6;padding-bottom:30px;\">\r\n" + 
				"    <table width=\"640\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"margin:0 auto;\"><tbody><tr><td>\r\n" + 
				"        <div style=\"width:640px;font:24px/42px helvetica,'Hiragino Sans GB','Microsoft YaHei','微软雅黑','宋体';color:#606060;background:#f1f4f6;text-align:center;\">\r\n" + 
				"            <div style=\"margin:0 10px;height:10px;overflow:hidden;text-indent:-2000px;background:#0ebb9a;\"></div>\r\n" + 
				"            <div style=\"overflow:hidden;background:url(https://aq.reg.163.com/res/email/bd3.jpg) repeat-y;text-align:center;\">\r\n" + 
				"                <div style=\"width:520px;margin:0 auto;text-align:left;\">\r\n" + 
				"                    <div style=\"height:73px;padding:30px 0;font-size:0;color:#1d1d1d;\">\r\n" + 
				"                        <div style=\"width:70px;height:73px;background:url(https://aq.reg.163.com/res/email/email-logo.png);display:inline-block;float:left;\"></div>\r\n" + 
				"                        <div style=\"vertical-align:top;padding-left:10px;height:73px;line-height:73px;display:inline-block;font-size:30px;color:#0ebb9a;\">亲爱的ISSUE注册帐号用户：</div>\r\n" + 
				"                    </div>\r\n" + 
				"                    <div style=\"padding-bottom:16px;\">您好！感谢注册IBM邮箱账号,如果您正在注册Issue账号: <span style=\"color:#ee583b;\"></span> 请复制下面验证码     </div>\r\n" + 
				"                    <div id=\"message\" style=\"text-align:center ;display:block;margin:0 auto;text-align:center;width:440px;height:88px;line-height:88px;border-radius:40px;background:#faa22a;color:#fff;text-decoration:none;font-size:36px;\" rel=\"noopener\">"+need+"</div>\r\n" + 
				"                    <div style=\"padding-top:33px;\">\r\n" + 
				"                        为了确保您的帐号安全，该验证码仅<span style=\"color:#ee583b;\">24小时</span>内有效。\r\n" + 
				"                    </div>\r\n" + 
				"                    <div style=\"padding-bottom:30px;\"> 如果该验证码已经失效，请您进入 <a href=\"\" style=\"color:#09b76f;text-decoration:none;\" target=\"_blank\" rel=\"noopener\">Issue注册系统</a>- 重新验证发送。</div>\r\n" + 
				"                </div>\r\n" + 
				"                <img src="+ url +" style=\"width:600px;height:447px;margin:0 auto;overflow:hidden;text-align:center;\">\r\n" + 
				"                </img>\r\n" + 
				"            </div>\r\n" + 
				"            <div style=\"margin:0 10px;height:10px;overflow:hidden;text-indent:-2000px;background:#0ebb9a;\"></div>\r\n" + 
				"        </div>\r\n" + 
				"    </td></tr></tbody></table>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<style type=\"text/css\">.qmbox style, .qmbox script, .qmbox head, .qmbox link, .qmbox meta {display: none !important;}</style></div></div>";
		
		return message;
	}
	
}
