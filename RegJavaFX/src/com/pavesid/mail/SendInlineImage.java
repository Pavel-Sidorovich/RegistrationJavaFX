package com.pavesid.mail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendInlineImage {
    public static void main(String[] args) {
        // Recipient's email ID needs to be mentioned.
        send("sidorovichpavelalex@gmail.com", "fdshdg5tT^");
    }

    public static void send(String name, String pass) {
        String to = "sidorovichpavelalex@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "funnycjokes@gmail.com";
        final String username = "funnycjokes@gmail.com";//change accordingly
        final String password = "";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "relay.jangosmtp.net";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Testing Subject");

            // This mail has 2 part, the BODY and the embedded image
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                    "\n" +
                    "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" +
                    "<head>\n" +
                    "<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n" +
                    "<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
                    "<meta content=\"width=device-width\" name=\"viewport\"/>\n" +
                    "<!--[if !mso]><!-->\n" +
                    "<meta content=\"IE=edge\" http-equiv=\"X-UA-Compatible\"/>\n" +
                    "<!--<![endif]-->\n" +
                    "<title></title>\n" +
                    "<!--[if !mso]><!-->\n" +
                    "<link href=\"https://fonts.googleapis.com/css?family=Lato\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                    "<!--<![endif]-->\n" +
                    "<style type=\"text/css\">\n" +
                    "\t\tbody {\n" +
                    "\t\t\tmargin: 0;\n" +
                    "\t\t\tpadding: 0;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\ttable,\n" +
                    "\t\ttd,\n" +
                    "\t\ttr {\n" +
                    "\t\t\tvertical-align: top;\n" +
                    "\t\t\tborder-collapse: collapse;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t* {\n" +
                    "\t\t\tline-height: inherit;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\ta[x-apple-data-detectors=true] {\n" +
                    "\t\t\tcolor: inherit !important;\n" +
                    "\t\t\ttext-decoration: none !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.ie-browser table {\n" +
                    "\t\t\ttable-layout: fixed;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t[owa] .img-container div,\n" +
                    "\t\t[owa] .img-container button {\n" +
                    "\t\t\tdisplay: block !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t[owa] .fullwidth button {\n" +
                    "\t\t\twidth: 100% !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t[owa] .block-grid .col {\n" +
                    "\t\t\tdisplay: table-cell;\n" +
                    "\t\t\tfloat: none !important;\n" +
                    "\t\t\tvertical-align: top;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.ie-browser .block-grid,\n" +
                    "\t\t.ie-browser .num12,\n" +
                    "\t\t[owa] .num12,\n" +
                    "\t\t[owa] .block-grid {\n" +
                    "\t\t\twidth: 650px !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.ie-browser .mixed-two-up .num4,\n" +
                    "\t\t[owa] .mixed-two-up .num4 {\n" +
                    "\t\t\twidth: 216px !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.ie-browser .mixed-two-up .num8,\n" +
                    "\t\t[owa] .mixed-two-up .num8 {\n" +
                    "\t\t\twidth: 432px !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.ie-browser .block-grid.two-up .col,\n" +
                    "\t\t[owa] .block-grid.two-up .col {\n" +
                    "\t\t\twidth: 324px !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.ie-browser .block-grid.three-up .col,\n" +
                    "\t\t[owa] .block-grid.three-up .col {\n" +
                    "\t\t\twidth: 324px !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.ie-browser .block-grid.four-up .col [owa] .block-grid.four-up .col {\n" +
                    "\t\t\twidth: 162px !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.ie-browser .block-grid.five-up .col [owa] .block-grid.five-up .col {\n" +
                    "\t\t\twidth: 130px !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.ie-browser .block-grid.six-up .col,\n" +
                    "\t\t[owa] .block-grid.six-up .col {\n" +
                    "\t\t\twidth: 108px !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.ie-browser .block-grid.seven-up .col,\n" +
                    "\t\t[owa] .block-grid.seven-up .col {\n" +
                    "\t\t\twidth: 92px !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.ie-browser .block-grid.eight-up .col,\n" +
                    "\t\t[owa] .block-grid.eight-up .col {\n" +
                    "\t\t\twidth: 81px !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.ie-browser .block-grid.nine-up .col,\n" +
                    "\t\t[owa] .block-grid.nine-up .col {\n" +
                    "\t\t\twidth: 72px !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.ie-browser .block-grid.ten-up .col,\n" +
                    "\t\t[owa] .block-grid.ten-up .col {\n" +
                    "\t\t\twidth: 60px !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.ie-browser .block-grid.eleven-up .col,\n" +
                    "\t\t[owa] .block-grid.eleven-up .col {\n" +
                    "\t\t\twidth: 54px !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.ie-browser .block-grid.twelve-up .col,\n" +
                    "\t\t[owa] .block-grid.twelve-up .col {\n" +
                    "\t\t\twidth: 50px !important;\n" +
                    "\t\t}\n" +
                    "\t</style>\n" +
                    "<style id=\"media-query\" type=\"text/css\">\n" +
                    "\t\t@media only screen and (min-width: 670px) {\n" +
                    "\t\t\t.block-grid {\n" +
                    "\t\t\t\twidth: 650px !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid .col {\n" +
                    "\t\t\t\tvertical-align: top;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid .col.num12 {\n" +
                    "\t\t\t\twidth: 650px !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid.mixed-two-up .col.num3 {\n" +
                    "\t\t\t\twidth: 162px !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid.mixed-two-up .col.num4 {\n" +
                    "\t\t\t\twidth: 216px !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid.mixed-two-up .col.num8 {\n" +
                    "\t\t\t\twidth: 432px !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid.mixed-two-up .col.num9 {\n" +
                    "\t\t\t\twidth: 486px !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid.two-up .col {\n" +
                    "\t\t\t\twidth: 325px !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid.three-up .col {\n" +
                    "\t\t\t\twidth: 216px !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid.four-up .col {\n" +
                    "\t\t\t\twidth: 162px !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid.five-up .col {\n" +
                    "\t\t\t\twidth: 130px !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid.six-up .col {\n" +
                    "\t\t\t\twidth: 108px !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid.seven-up .col {\n" +
                    "\t\t\t\twidth: 92px !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid.eight-up .col {\n" +
                    "\t\t\t\twidth: 81px !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid.nine-up .col {\n" +
                    "\t\t\t\twidth: 72px !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid.ten-up .col {\n" +
                    "\t\t\t\twidth: 65px !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid.eleven-up .col {\n" +
                    "\t\t\t\twidth: 59px !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid.twelve-up .col {\n" +
                    "\t\t\t\twidth: 54px !important;\n" +
                    "\t\t\t}\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t@media (max-width: 670px) {\n" +
                    "\n" +
                    "\t\t\t.block-grid,\n" +
                    "\t\t\t.col {\n" +
                    "\t\t\t\tmin-width: 320px !important;\n" +
                    "\t\t\t\tmax-width: 100% !important;\n" +
                    "\t\t\t\tdisplay: block !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.block-grid {\n" +
                    "\t\t\t\twidth: 100% !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.col {\n" +
                    "\t\t\t\twidth: 100% !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.col>div {\n" +
                    "\t\t\t\tmargin: 0 auto;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\timg.fullwidth,\n" +
                    "\t\t\timg.fullwidthOnMobile {\n" +
                    "\t\t\t\tmax-width: 100% !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.no-stack .col {\n" +
                    "\t\t\t\tmin-width: 0 !important;\n" +
                    "\t\t\t\tdisplay: table-cell !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.no-stack.two-up .col {\n" +
                    "\t\t\t\twidth: 50% !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.no-stack .col.num4 {\n" +
                    "\t\t\t\twidth: 33% !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.no-stack .col.num8 {\n" +
                    "\t\t\t\twidth: 66% !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.no-stack .col.num4 {\n" +
                    "\t\t\t\twidth: 33% !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.no-stack .col.num3 {\n" +
                    "\t\t\t\twidth: 25% !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.no-stack .col.num6 {\n" +
                    "\t\t\t\twidth: 50% !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.no-stack .col.num9 {\n" +
                    "\t\t\t\twidth: 75% !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.video-block {\n" +
                    "\t\t\t\tmax-width: none !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.mobile_hide {\n" +
                    "\t\t\t\tmin-height: 0px;\n" +
                    "\t\t\t\tmax-height: 0px;\n" +
                    "\t\t\t\tmax-width: 0px;\n" +
                    "\t\t\t\tdisplay: none;\n" +
                    "\t\t\t\toverflow: hidden;\n" +
                    "\t\t\t\tfont-size: 0px;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.desktop_hide {\n" +
                    "\t\t\t\tdisplay: block !important;\n" +
                    "\t\t\t\tmax-height: none !important;\n" +
                    "\t\t\t}\n" +
                    "\t\t}\n" +
                    "\t</style>\n" +
                    "</head>\n" +
                    "<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #F5F5F5;\">\n" +
                    "<style id=\"media-query-bodytag\" type=\"text/css\">\n" +
                    "@media (max-width: 670px) {\n" +
                    "  .block-grid {\n" +
                    "    min-width: 320px!important;\n" +
                    "    max-width: 100%!important;\n" +
                    "    width: 100%!important;\n" +
                    "    display: block!important;\n" +
                    "  }\n" +
                    "  .col {\n" +
                    "    min-width: 320px!important;\n" +
                    "    max-width: 100%!important;\n" +
                    "    width: 100%!important;\n" +
                    "    display: block!important;\n" +
                    "  }\n" +
                    "  .col > div {\n" +
                    "    margin: 0 auto;\n" +
                    "  }\n" +
                    "  img.fullwidth {\n" +
                    "    max-width: 100%!important;\n" +
                    "    height: auto!important;\n" +
                    "  }\n" +
                    "  img.fullwidthOnMobile {\n" +
                    "    max-width: 100%!important;\n" +
                    "    height: auto!important;\n" +
                    "  }\n" +
                    "  .no-stack .col {\n" +
                    "    min-width: 0!important;\n" +
                    "    display: table-cell!important;\n" +
                    "  }\n" +
                    "  .no-stack.two-up .col {\n" +
                    "    width: 50%!important;\n" +
                    "  }\n" +
                    "  .no-stack.mixed-two-up .col.num4 {\n" +
                    "    width: 33%!important;\n" +
                    "  }\n" +
                    "  .no-stack.mixed-two-up .col.num8 {\n" +
                    "    width: 66%!important;\n" +
                    "  }\n" +
                    "  .no-stack.three-up .col.num4 {\n" +
                    "    width: 33%!important\n" +
                    "  }\n" +
                    "  .no-stack.four-up .col.num3 {\n" +
                    "    width: 25%!important\n" +
                    "  }\n" +
                    "}\n" +
                    "</style>\n" +
                    "<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n" +
                    "<table bgcolor=\"#F5F5F5\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #F5F5F5; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                    "<td style=\"word-break: break-word; vertical-align: top; border-collapse: collapse;\" valign=\"top\">\n" +
                    "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#F5F5F5\"><![endif]-->\n" +
                    "<div style=\"background-color:transparent;\">\n" +
                    "<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 650px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;;\">\n" +
                    "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                    "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:650px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"650\" style=\"background-color:transparent;width:650px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                    "<div class=\"col num12\" style=\"min-width: 320px; max-width: 650px; display: table-cell; vertical-align: top;;\">\n" +
                    "<div style=\"width:100% !important;\">\n" +
                    "<!--[if (!mso)&(!IE)]><!-->\n" +
                    "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                    "<!--<![endif]-->\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                    "<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px; border-collapse: collapse;\" valign=\"top\">\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" height=\"10\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%; border-top: 0px solid transparent; height: 10px;\" valign=\"top\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                    "<td height=\"10\" style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; border-collapse: collapse;\" valign=\"top\"><span></span></td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<!--[if (!mso)&(!IE)]><!-->\n" +
                    "</div>\n" +
                    "<!--<![endif]-->\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                    "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "<div style=\"background-color:transparent;\">\n" +
                    "<div class=\"block-grid two-up no-stack\" style=\"Margin: 0 auto; min-width: 320px; max-width: 650px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;;\">\n" +
                    "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                    "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:650px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"325\" style=\"background-color:#FFFFFF;width:325px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 25px; padding-top:25px; padding-bottom:25px;\"><![endif]-->\n" +
                    "<div class=\"col num6\" style=\"min-width: 320px; max-width: 325px; display: table-cell; vertical-align: top;;\">\n" +
                    "<div style=\"width:100% !important;\">\n" +
                    "<!--[if (!mso)&(!IE)]><!-->\n" +
                    "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:25px; padding-bottom:25px; padding-right: 0px; padding-left: 25px;\">\n" +
                    "<!--<![endif]-->\n" +
                    "<div align=\"left\" class=\"img-container left fixedwidth\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                    "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"left\"><![endif]--><img alt=\"Image\" border=\"0\" class=\"left fixedwidth\" src=\"cid:logo\" style=\"outline: none; text-decoration: none; -ms-interpolation-mode: bicubic; clear: both; border: 0; height: auto; float: none; width: 100%; max-width: 195px; display: block;\" title=\"Image\" width=\"195\"/>\n" +
                    "<!--[if mso]></td></tr></table><![endif]-->\n" +
                    "</div>\n" +
                    "<!--[if (!mso)&(!IE)]><!-->\n" +
                    "</div>\n" +
                    "<!--<![endif]-->\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                    "<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"325\" style=\"background-color:#FFFFFF;width:325px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 25px; padding-left: 0px; padding-top:25px; padding-bottom:25px;\"><![endif]-->\n" +
                    "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                    "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "<div style=\"background-color:transparent;\">\n" +
                    "<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 650px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #D6E7F0;;\">\n" +
                    "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#D6E7F0;\">\n" +
                    "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:650px\"><tr class=\"layout-full-width\" style=\"background-color:#D6E7F0\"><![endif]-->\n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"650\" style=\"background-color:#D6E7F0;width:650px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 25px; padding-left: 25px; padding-top:5px; padding-bottom:60px;\"><![endif]-->\n" +
                    "<div class=\"col num12\" style=\"min-width: 320px; max-width: 650px; display: table-cell; vertical-align: top;;\">\n" +
                    "<div style=\"width:100% !important;\">\n" +
                    "<!--[if (!mso)&(!IE)]><!-->\n" +
                    "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:60px; padding-right: 25px; padding-left: 25px;\">\n" +
                    "<!--<![endif]-->\n" +
                    "<div align=\"center\" class=\"img-container center fixedwidth\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                    "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]-->\n" +
                    "<div style=\"font-size:1px;line-height:45px\"> </div>\n" +
                    "<!--[if mso]></td></tr></table><![endif]-->\n" +
                    "</div>\n" +
                    "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 15px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, Verdana, sans-serif\"><![endif]-->\n" +
                    "<div style=\"color:#052d3d;font-family:'Lato', Tahoma, Verdana, Segoe, sans-serif;line-height:150%;padding-top:20px;padding-right:10px;padding-bottom:0px;padding-left:15px;\">\n" +
                    "<div style=\"line-height: 18px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; font-size: 12px; color: #052d3d;\">\n" +
                    "<p style=\"text-align: center; line-height: 75px; font-size: 14px; margin: 0;\"><span style=\"font-size: 50px;\"><strong><span style=\"line-height: 75px; font-size: 50px;\"><span style=\"line-height: 57px; font-size: 38px;\">WELCOME</span></span></strong></span></p>\n" +
                    "<p style=\"text-align: center; line-height: 51px; font-size: 14px; margin: 0;\"><span style=\"font-size: 34px;\"><strong><span style=\"line-height: 51px; font-size: 34px;\"><span style=\"color: #2190e3; line-height: 51px; font-size: 34px;\">UserNameTemp</span></span></strong></span></p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "<!--[if mso]></td></tr></table><![endif]-->\n" +
                    "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, Verdana, sans-serif\"><![endif]-->\n" +
                    "<div style=\"color:#555555;font-family:'Lato', Tahoma, Verdana, Segoe, sans-serif;line-height:120%;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                    "<div style=\"line-height: 14px; font-size: 12px; color: #555555; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif;\">\n" +
                    "<p style=\"text-align: center; line-height: 21px; font-size: 14px; margin: 0;\"><span style=\"color: #000000; font-size: 18px;\">Your password</span></p>\n" +
                    "<p style=\"text-align: center; line-height: 14px; font-size: 12px; margin: 0;\"><span style=\"color: #007600; font-size: large;\">UserPassTemp</span></p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "<!--[if mso]></td></tr></table><![endif]-->\n" +
                    "<!--[if (!mso)&(!IE)]><!-->\n" +
                    "</div>\n" +
                    "<!--<![endif]-->\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                    "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "<div style=\"background-color:transparent;\">\n" +
                    "<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 650px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;;\">\n" +
                    "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                    "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:650px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"650\" style=\"background-color:transparent;width:650px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:20px; padding-bottom:60px;\"><![endif]-->\n" +
                    "<div class=\"col num12\" style=\"min-width: 320px; max-width: 650px; display: table-cell; vertical-align: top;;\">\n" +
                    "<div style=\"width:100% !important;\">\n" +
                    "<!--[if (!mso)&(!IE)]><!-->\n" +
                    "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:20px; padding-bottom:60px; padding-right: 0px; padding-left: 0px;\">\n" +
                    "<!--<![endif]-->\n" +
                    "<table cellpadding=\"0\" cellspacing=\"0\" class=\"social_icons\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                    "<td style=\"word-break: break-word; vertical-align: top; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px; border-collapse: collapse;\" valign=\"top\">\n" +
                    "<table activate=\"activate\" align=\"center\" alignment=\"alignment\" cellpadding=\"0\" cellspacing=\"0\" class=\"social_table\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: undefined; mso-table-tspace: 0; mso-table-rspace: 0; mso-table-bspace: 0; mso-table-lspace: 0;\" to=\"to\" valign=\"top\">\n" +
                    "<tbody>\n" +
                    "<tr align=\"center\" style=\"vertical-align: top; display: inline-block; text-align: center;\" valign=\"top\">\n" +
                    "<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 8px; padding-left: 8px; border-collapse: collapse;\" valign=\"top\"><a href=\"https://www.facebook.com/\" target=\"_blank\"><img alt=\"Facebook\" height=\"32\" src=\"cid:facebook\" style=\"outline: none; text-decoration: none; -ms-interpolation-mode: bicubic; clear: both; height: auto; float: none; border: none; display: block;\" title=\"Facebook\" width=\"32\"/></a></td>\n" +
                    "<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 8px; padding-left: 8px; border-collapse: collapse;\" valign=\"top\"><a href=\"https://twitter.com/\" target=\"_blank\"><img alt=\"Twitter\" height=\"32\" src=\"cid:twitter\" style=\"outline: none; text-decoration: none; -ms-interpolation-mode: bicubic; clear: both; height: auto; float: none; border: none; display: block;\" title=\"Twitter\" width=\"32\"/></a></td>\n" +
                    "<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 8px; padding-left: 8px; border-collapse: collapse;\" valign=\"top\"><a href=\"https://instagram.com/\" target=\"_blank\"><img alt=\"Instagram\" height=\"32\" src=\"cid:instagram\" style=\"outline: none; text-decoration: none; -ms-interpolation-mode: bicubic; clear: both; height: auto; float: none; border: none; display: block;\" title=\"Instagram\" width=\"32\"/></a></td>\n" +
                    "<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 8px; padding-left: 8px; border-collapse: collapse;\" valign=\"top\"><a href=\"https://www.pinterest.com/\" target=\"_blank\"><img alt=\"Pinterest\" height=\"32\" src=\"cid:pinterest\" style=\"outline: none; text-decoration: none; -ms-interpolation-mode: bicubic; clear: both; height: auto; float: none; border: none; display: block;\" title=\"Pinterest\" width=\"32\"/></a></td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "<!--[if mso]></td></tr></table><![endif]-->\n" +
                    "<!--[if (!mso)&(!IE)]><!-->\n" +
                    "</div>\n" +
                    "<!--<![endif]-->\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                    "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<!--[if (IE)]></div><![endif]-->\n" +
                    "</body>\n" +
                    "</html>";

            htmlText = htmlText.replaceAll("UserNameTemp", name);
            htmlText = htmlText.replaceAll("UserPassTemp", pass);
            messageBodyPart.setContent(htmlText, "text/html");
            // add it

            multipart.addBodyPart(messageBodyPart);

            Map<String, String> inlineImages = new HashMap<>();
//            inlineImages.put("facebook", "/images/facebook@2x.png");
//            inlineImages.put("logo", "/images/pavesid@2x.png");
//            inlineImages.put("instagram", "/images/instagram@2x.png");
//            inlineImages.put("pinterest", "/images/pinterest@2x.png");
//            inlineImages.put("twitter", "/images/twitter@2x.png");

            // creates multi-part
            //Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // adds inline image attachments
            if (inlineImages != null && inlineImages.size() > 0) {
                Set<String> setImageID = inlineImages.keySet();

                for (String contentId : setImageID) {
                    MimeBodyPart imagePart = new MimeBodyPart();
                    imagePart.setHeader("Content-ID", "<" + contentId + ">");
                    imagePart.setDisposition(MimeBodyPart.INLINE);

                    String imageFilePath = inlineImages.get(contentId);
                    try {
                        imagePart.attachFile(imageFilePath);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    multipart.addBodyPart(imagePart);
                }
            }

            // put everything together
            message.setContent(multipart);
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}