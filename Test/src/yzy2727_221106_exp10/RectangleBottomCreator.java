package yzy2727_221106_exp10;

public class RectangleBottomCreator extends BottomCreator {

    @Override
    public GeometryBottom getBottom(double... args) {
        if(args.length!=2){
            throw new RuntimeException("制造矩形需要两个参数：长，宽");
        }
        return new RectangleBottom(args[0],args[1]);
    }

}
