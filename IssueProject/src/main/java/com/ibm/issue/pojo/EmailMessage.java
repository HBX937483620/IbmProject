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
				"               <img src=\"https://www.ibm.com/images/portal/C030478K15316S90/IBMGCG.png\">\r\n" + 
				"                <div style=\"padding-top:33px;\">\r\n" +
				"                      关注IBM公众号获取更多资讯</div>    "+
				"            </div>\r\n" + 
				"            <div style=\"margin:0 10px;height:10px;overflow:hidden;text-indent:-2000px;background:#0ebb9a;\"></div>\r\n" + 
				"        </div>\r\n" + 
				"    </td></tr></tbody></table>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"    <style type=\"text/css\">.qmbox style, .qmbox script, .qmbox head, .qmbox link, .qmbox meta {display: none !important;}</style></div></div>\r\n" + 
				"</body>";
		return message;
	}
	
	public static String sendSession() {
		String message = "<div>\r\n" + 
				"        <span class=\"genEmailNicker\">\r\n" + 
				"        \r\n" + 
				"        </span>\r\n" + 
				"        <br>\r\n" + 
				"        <span class=\"genEmailContent\">\r\n" + 
				"                  \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        <div id=\"cTMail-Wrap\" style=\"word-break: break-all;box-sizing:border-box;text-align:center;min-width:320px; max-width:660px; border:1px solid #f6f6f6; background-color:#f7f8fa; margin:auto; padding:20px 0 30px; font-family:'helvetica neue',PingFangSC-Light,arial,'hiragino sans gb','microsoft yahei ui','microsoft yahei',simsun,sans-serif\">\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"            \r\n" + 
				"        <div class=\"main-content\" style=\"\">\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                \r\n" + 
				"        <table style=\"width:100%;font-weight:300;margin-bottom:10px;border-collapse:collapse\">\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                    <tbody>\r\n" + 
				"                        <tr style=\"font-weight:300\">\r\n" + 
				"                            <td style=\"width:3%;max-width:30px;\"></td>\r\n" + 
				"                            <td style=\"max-width:600px;\">\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                                \r\n" + 
				"        <div id=\"cTMail-logo\" style=\"width:92px; height:25px;\">\r\n" + 
				"                                    <a href=\"https://www.ibm.com/cn-zh\" rel=\"noopener\" target=\"_blank\"><img border=\"0\" src=\"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606141737660&di=1ee32e6484e1a7981b403411f7091eb7&imgtype=0&src=http%3A%2F%2Fsup.user.img18.51sole.com%2Fimages3%2F20130104%2F1189644_2013141050396.jpg\" style=\"width:92px; height:25px;display:block\"></a>\r\n" + 
				"                                </div>\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                                <p style=\"height:2px;background-color: #00a4ff;border: 0;font-size:0;padding:0;width:100%;margin-top:20px;\"></p>\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                                \r\n" + 
				"        <div id=\"cTMail-inner\" style=\"background-color:#fff; padding:23px 0 20px;box-shadow: 0px 1px 1px 0px rgba(122, 55, 55, 0.2);text-align:left;\">\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                                    \r\n" + 
				"        <table style=\"width:100%;font-weight:300;margin-bottom:10px;border-collapse:collapse;text-align:left;\">\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                                        <tbody>\r\n" + 
				"                                            <tr style=\"font-weight:300\">\r\n" + 
				"                                                <td style=\"width:3.2%;max-width:30px;\"></td>\r\n" + 
				"                                                <td style=\"max-width:480px;text-align:left;\">\r\n" + 
				"                                                    <h1 id=\"cTMail-title\" style=\"font-weight:bold;font-size:20px; line-height:36px; margin:0 0 16px;\">【ISSUE跟踪】Issue事务通知</h1>\r\n" + 
				"                                                    <p id=\"cTMail-userName\" style=\"font-size:14px;color:#333; line-height:24px; margin:0;\">尊敬的用户，您好！</p>\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                                                    <p class=\"cTMail-content\" style=\"line-height: 24px; margin: 6px 0px 0px; overflow-wrap: break-word; word-break: break-all;\"><span style=\"color: rgb(51, 51, 51); font-size: 14px;\">您好，用户666指派给您一份issue事务，请及时上线查看详情并修改。您现在的issue事务详情如下：</span></p>\r\n" + 
				"        <p class=\"cTMail-content\" style=\"line-height: 24px; margin: 6px 0px 0px; overflow-wrap: break-word; word-break: break-all;\"><span style=\"color: rgb(51, 51, 51); font-size: 14px;\"></span></p><p style=\"padding-left:14px;font-size:14px;\"></p><table cellpadding=\"5\" cellspacing=\"0\" border=\"1\" bordercolor=\"#CCCCCC\" style=\"font-size:14px; table-layout: fixed;word-break: break-word;\" width=\"80%\"><colgroup><col width=\"13%\">  <col width=\"14%\"></colgroup><tbody><tr><th>序号</th><th>用户ID</th><th>用户姓名</th><th>创建Issue数</th><th>收到Issue数</th><th>修改Issue数</th><th>完成率</th></tr><tr><td>云服务器CVM</td><td>未命名</td><td>ins-bjdzh18k</td><td>广州</td><td>默认项目</td><td>\r\n" + 
				"            <span style=\"border-bottom: 1px dashed rgb(204, 204, 204); position: relative;\" t=\"5\" times=\"\" isout=\"0\">2020-06-24</span></td><td>内网IP:172.16.0.2<br>外网IP:129.204.225.203<br></td></tr></tbody></table><p></p>\r\n" + 
				"        <p class=\"cTMail-content\" style=\"line-height: 24px; margin: 6px 0px 0px; overflow-wrap: break-word; word-break: break-all;\"><span style=\"color: rgb(51, 51, 51); font-size: 14px;\">祝您生活愉快，工作顺利。</span></p>\r\n" + 
				"        <p class=\"cTMail-content\" style=\"line-height: 24px; margin: 6px 0px 0px; overflow-wrap: break-word; word-break: break-all;\"><span style=\"color: rgb(51, 51, 51); font-size: 14px;\"><br>\r\n" + 
				"        </span></p>\r\n" + 
				"        <p class=\"cTMail-content\" style=\"line-height: 24px; margin: 6px 0px 0px; overflow-wrap: break-word; word-break: break-all;\"><span style=\"color: rgb(51, 51, 51); font-size: 14px;\">此致 </span></p>\r\n" + 
				"        <p class=\"cTMail-content\" style=\"line-height: 24px; margin: 6px 0px 0px; overflow-wrap: break-word; word-break: break-all;\"><strong style=\"color: rgb(51, 51, 51); font-size: 14px;\">皮卡丘团队</strong></p>\r\n" + 
				"        \r\n" + 
				"                                            </td>\r\n" + 
				"                                            <td style=\"width:3.2%;max-width:30px;\"></td>\r\n" + 
				"                                        </tr>\r\n" + 
				"                                    </tbody>\r\n" + 
				"                                    \r\n" + 
				"        \r\n" + 
				"                                \r\n" + 
				"        </table>\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                            </div>\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                            \r\n" + 
				"        <div id=\"cTMail-copy\" style=\"text-align:center; font-size:12px; line-height:18px; color:#999\">\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                                \r\n" + 
				"        <table style=\"width:100%;font-weight:300;margin-bottom:10px;border-collapse:collapse\">\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                                    <tbody>\r\n" + 
				"                                        <tr style=\"font-weight:300\">\r\n" + 
				"                                            <td style=\"width:3.2%;max-width:30px;\"></td>\r\n" + 
				"                                            <td style=\"max-width:540px;\">\r\n" + 
				"                                                <p style=\"text-align:center; margin:20px auto 14px auto;font-size:12px;color:#999;\">此为系统邮件，请勿回复。 </p>\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                                                <p style=\"text-align:center;margin:0 auto 4px;\"><img border=\"0\" src=\"https://1.cms.s81c.com/sites/default/files/2019-04-04/qrcode_2.jpg\" style=\"width:120px; height:120px; margin:0 auto;\"></p>\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                                                <p id=\"cTMail-rights\" style=\"max-width: 100%; margin:auto;font-size:12px;color:#999;text-align:center;line-height:22px;\">关注IBM公众号获取更多资讯\r\n" + 
				"                                                    <br>\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                                                    <img src=\"http://m.qpic.cn/psc?/693897396/bqQfVz5yrrGYSXMvKr.cqZBufDlVyAnhODQa3YayIK5XHxqiVcGpDXCq8TMXIMfbzE8rHn6qGq1RRQV2ta4L46JUpJMYcPJcjFtbJu1TxOU!/b&bo=rgGuAQAAAAABByA!&rf=viewer_4\" style=\"margin-top: 10px;width: 64px;height: 64px;\">\r\n" + 
				"                                                    <img src=\"http://m.qpic.cn/psc?/693897396/bqQfVz5yrrGYSXMvKr.cqVHMn2JSBs6LfGgpQwP4kn7NoPsAY.Ogmaik8s38bqRBD6Qznzxx1T1wiGAeJ3jotC3jB.*fU4AlPHlcIgsB1t4!/b&bo=rgGuAQAAAAABByA!&rf=viewer_4\" style=\"margin-top: 10px;width: 64px;height: 64px;\">\r\n" + 
				"                                                    <img src=\"http://m.qpic.cn/psc?/693897396/bqQfVz5yrrGYSXMvKr.cqUw6G*2T28e2jaP51NbYPXRtushxmniH2AXKTl4HpvpoSAsekGeh7fcIG3VHn3nUqpsK7Nm2q4DGKo1J31QOyIY!/b&bo=rgGuAQAAAAABByA!&rf=viewer_4\" style=\"margin-top: 10px;width: 64px;height: 64px;\">\r\n" + 
				"                                                    <img src=\"http://m.qpic.cn/psc?/693897396/bqQfVz5yrrGYSXMvKr.cqWq4MWkhY0jAOIwXSMwXGNRINjOYJAnEl25BI.B5X68j2L6mrYeNg6rEzoKxWHYUQZvE*7G.NfDlWF9tdIJK45U!/b&bo=rgGuAQAAAAABByA!&rf=viewer_4\" style=\"margin-top: 10px;width: 64px;height: 64px;\">\r\n" + 
				"                                                    <img src=\"http://m.qpic.cn/psc?/693897396/bqQfVz5yrrGYSXMvKr.cqWZi*T4w7x0rhnqLdkQPnrl5.r3pO2irdOKei5KoEkM07bv86BHZS1HPUhYo1ggE0zopRwdyVQ1kilZY3namBaY!/b&bo=rgGuAQAAAAABByA!&rf=viewer_4\" style=\"margin-top: 10px;width: 64px;height: 64px;\">\r\n" + 
				"                                                    <img src=\"http://m.qpic.cn/psc?/693897396/bqQfVz5yrrGYSXMvKr.cqauxQwTKVhZXikar*QQ2.E.xOZn9Xh3GSoPsudAHBelI84U1IQvsY7ZsBSTYhuFn**w02AeawxTBL..ZCqdgWJ0!/b&bo=rgGuAQAAAAABByA!&rf=viewer_4\" style=\"margin-top: 10px;width: 64px;height: 64px;\">\r\n" + 
				"                                                    <img src=\"http://m.qpic.cn/psc?/693897396/TmEUgtj9EK6.7V8ajmQrEETE0bS*BazEFvGim9yZajNujm*Q9CB8FmlI58ev4XJCFpabjXxA5MKfMiB12SvQRyEmnqfkAMffgQGxcCmopPc!/b&bo=rgGuAQAAAAABFzA!&rf=viewer_4\" style=\"margin-top: 10px;width: 64px;height: 64px;\">\r\n" + 
				"                                                    <img src=\"http://m.qpic.cn/psc?/693897396/TmEUgtj9EK6.7V8ajmQrEITwoPKLIm0Ln77nKqIxbBXgbyKbnRgd8P*4aEsMIYsH3*C9xatj7AQMu4ZjEpNBmguCOgi0ZA.fPBynDtmXRms!/b&bo=VgNpAwAAAAABFw8!&rf=viewer_4\" style=\"margin-top: 10px;width: 64px;height: 64px;\">\r\n" + 
				"\r\n" + 
				"                                                    <br>\r\n" + 
				"                                                    <p id=\"cTMail-rights2\" style=\"max-width: 100%; margin:auto;font-size:12px;color:#999;text-align:center;line-height:22px;\">联系我们的团队成员获取更多技术问题\r\n" + 
				"\r\n" + 
				"                                                </p>\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                                            </td>\r\n" + 
				"                                            <td style=\"width:3.2%;max-width:30px;\"></td>\r\n" + 
				"                                        </tr>\r\n" + 
				"                                    </tbody>\r\n" + 
				"                                    \r\n" + 
				"        \r\n" + 
				"                                \r\n" + 
				"        </table>\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                            </div>\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"                        </td>\r\n" + 
				"        \r\n" + 
				"                        <td style=\"width:3%;max-width:30px;\"></td>\r\n" + 
				"                    </tr>\r\n" + 
				"                </tbody>\r\n" + 
				"                \r\n" + 
				"        \r\n" + 
				"            \r\n" + 
				"        </table>\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        </div>\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        </div>\r\n" + 
				"        </span>\r\n" + 
				"        <br>\r\n" + 
				"        <span class=\"genEmailTail\">\r\n" + 
				"        \r\n" + 
				"        </span>\r\n" + 
				"        </div>";
		return message;
	}
	
}
