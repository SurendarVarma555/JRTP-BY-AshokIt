//package in.ashokit.utils;
//
//import in.ashokit.bindings.EligInfo;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.font.PDType1Font;
//import org.springframework.stereotype.Component;
//
//import java.io.File;
//import java.io.IOException;
//import java.time.format.DateTimeFormatter;
//
//@Component
//public class PdfUtils {
//
//    public File generatePdf (EligInfo eligInfo){
//        File file = null;
//
//        try {
//            // Create a new document
//            PDDocument document = new PDDocument();
//            PDPage page = new PDPage();
//            document.addPage(page);
//
//            // Create a new content stream
//            PDPageContentStream contentStream = new PDPageContentStream(document, page);
//
//            // Add content to the PDF
//            contentStream.setFont(PDType1Font., 12);
//            contentStream.beginText();
//            contentStream.newLineAtOffset(100, 700);
//            contentStream.showText("Eligibility Information:");
//            contentStream.newLine();
//            contentStream.showText("Case Number: " + eligInfo.getCaseNum());
//            contentStream.newLine();
//            contentStream.showText("Plan Name: " + eligInfo.getPlanName());
//            contentStream.newLine();
//            contentStream.showText("Plan Status: " + eligInfo.getPlanStatus());
//            contentStream.newLine();
//            contentStream.showText("Plan Start Date: " + eligInfo.getPlanStartDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
//            contentStream.newLine();
//            contentStream.showText("Plan End Date: " + eligInfo.getPlanEndDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
//            contentStream.newLine();
//            contentStream.showText("Benefit Amount: " + eligInfo.getBenfitAmt());
//            contentStream.newLine();
//            contentStream.showText("Denial Reason: " + eligInfo.getDenialRsn());
//            // Add more fields as needed
//            contentStream.endText();
//
//            // Close the content stream and save the document
//            contentStream.close();
//
//            // Choose a file location for the PDF
//            file = new File("eligibility_info.pdf");
//
//            // Save the document
//            document.save(file);
//
//            // Close the document
//            document.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return file;
//    }
//}
