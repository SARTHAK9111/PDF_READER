package org.example;

public class AnnotationTool {
    private AnnotationToolType type;
    private Color color;
    private Double strokeWidth;
    private String text;

    private AnnotationTool(AnnotationToolBuilder builder) {
        this.type = builder.type;
        this.color = builder.color;
        this.strokeWidth = builder.strokeWidth;
        this.text = builder.text;
    }

    public AnnotationTool(AnnotationToolType type, Color color, Double strokeWidth, String text) {
        this.type = type;
        this.color = color;
        this.strokeWidth = strokeWidth;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public AnnotationToolType getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public Double getStrokeWidth() {
        return strokeWidth;
    }

    public static class AnnotationToolBuilder {
        private AnnotationToolType type;
        private Color color;
        private Double strokeWidth;
        private String text;

        public AnnotationToolBuilder setType(AnnotationToolType type) {
            this.type = type;
            return this;
        }

        public AnnotationToolBuilder setColor(Color color) {
            this.color = color;
            return this;
        }

        public AnnotationToolBuilder setStrokeWidth(Double strokeWidth) {
            this.strokeWidth = strokeWidth;
            return this;
        }

        public AnnotationToolBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public AnnotationTool build() {
            return new AnnotationTool(this);
        }
    }
}
