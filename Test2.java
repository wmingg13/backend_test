import java.util.List;
import java.util.stream.*;
import java.util.*;

public class Drawing {
    public String[] colours;
    public String[] shapes;
    public static class Art {
        public String colour;
        public String shape;
        public Art(String colour, String shape) {
            this.colour = colour;
            this.shape = shape;
        }
    }
    public Drawing(String[] colours, String[] shapes) {
        this.colours = colours;
        this.shapes = shapes;
    }
    public List<Art> mix() {
        String[] colourList = this.colours;
        List<String> shapeList = Arrays.asList(this.shapes);
        List<Art> result = new ArrayList<Art>();
        
        for(String color : colourList){
            List<Art> newList = shapeList.stream().map(shape -> new Art(color, shape)).collect(Collectors.toList());
            result.addAll(newList);
        }
        return result;
    }

    public static void main(String[] args) {
        Drawing draw = new Drawing (new String[]{"red", "blue"}, new String[]{"circle"});
        List<Art> mixes= draw.mix();
        /*
        * Should print:
        * red, circle
        * blue, circle
        */
        for (Art art: mixes) {
            System.out.println(art.colour + ", " + art.shape);
        }
    }
}