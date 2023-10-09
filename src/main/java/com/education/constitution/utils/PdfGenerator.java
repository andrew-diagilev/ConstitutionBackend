package com.education.constitution.utils;

import com.education.constitution.model.users.AccessCode;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class PdfGenerator {
    public byte[] generatePdfWithKeys(List<AccessCode> codes) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        float margin = 50;
        float yStart = page.getMediaBox().getHeight() - margin;
        float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
        int rows = codes.size();
        int cols = 1;
        float rowHeight = 20f;
        float tableHeight = rowHeight * (float) rows;
        float colWidth = tableWidth / (float) cols;

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            // Рисование заголовка таблицы
           /* drawCell(contentStream, margin, yStart, colWidth, rowHeight, "Hello");
            yStart -= rowHeight;*/

            // Рисование ячеек с ключами доступа
            for (AccessCode code : codes) {
                if (yStart - tableHeight < 0) {
                    // Добавление новой страницы, если таблица выходит за границы текущей страницы
                    document.addPage(new PDPage(PDRectangle.A4));
                    page = document.getPage(document.getNumberOfPages() - 1);
                    yStart = page.getMediaBox().getHeight() - margin;
                    contentStream.close();
                    contentStream.addRect(0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());
                    contentStream.clip();
                    contentStream.close();
                }

                drawCell(contentStream, margin, yStart, colWidth, rowHeight, code.getCode());
                yStart -= rowHeight;
            }
        }
        document.save(outputStream);
        document.close();

        return outputStream.toByteArray();
    }

    private void drawCell(PDPageContentStream contentStream, float x, float y, float width, float height, String text) throws IOException {
        contentStream.setLineWidth(0.5f);

        // Нарисовать текст
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
        contentStream.newLineAtOffset(x + 2, y - 15);
        contentStream.showText(text);
        contentStream.endText();

        // Нарисовать границу
        contentStream.addRect(x, y - height, width, height);
        contentStream.stroke();
    }
}