package com.example.kdi.myapplication;

public class TestData {
    public static int[] getArticleContents() {
        int[] data = {R.string.string1, R.string.string2, R.string.string3};
        return data;
    }

    public static String getArticleTitle(int pos) {
        switch (pos) {
            case 0:
                return "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget";
            case 1:
                return "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque";
            case 2:
                return "The European languages are members of the same family. Their separate existence";
            default:
                return "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget";
        }
    }

    public static int getPoster() {
        double rand = Math.random();
        if (rand < 0.33333333d) {
            return R.drawable.poster;
        } else if (rand < 0.66666666d) {
            return R.drawable.poster2;
        } else {
            return  R.drawable.poster3;
        }
    }

    public static int getPoster(int pos) {
        switch (pos) {
            case 0:
                return R.drawable.image1;
            case 1:
                return R.drawable.image2;
            case 2:
                return R.drawable.image3;
            default:
                return R.drawable.image1;
        }
    }
}
