//Program that creates a 200x200 yellow square image.
var img = new SimpleImage(200,200);
for (var pixel of img.values()){
    pixel.setRed(255);
    pixel.setGreen(255);
}
print(img);
