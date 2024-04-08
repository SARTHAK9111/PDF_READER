package org.example;

public class PostItNote extends AnnotationTool {
    private String message;

    private PostItNote(PostItNoteBuilder builder) {
        super(builder.type, builder.color, builder.strokeWidth, builder.text);
        this.message = builder.message;
    }

    public String getMessage() {
        return message;
    }

    // PostItNoteBuilder class
    public static class PostItNoteBuilder {
        private AnnotationToolType type;
        private Color color;
        private Double strokeWidth;
        private String text;
        private String message;

        public PostItNoteBuilder setType(AnnotationToolType type) {
            this.type = type;
            return this;
        }

        public PostItNoteBuilder setColor(Color color) {
            this.color = color;
            return this;
        }

        public PostItNoteBuilder setWidth(Double strokeWidth) {
            this.strokeWidth = strokeWidth;
            return this;
        }

        public PostItNoteBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public PostItNoteBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public PostItNote build() {
            return new PostItNote(this);
        }
    }
}
