for f in `find . -name "*.png"`
do
    convert $f -size 640x640 $f.resized.png
done
