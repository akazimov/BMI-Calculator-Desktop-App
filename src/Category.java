public enum Category {
    UNDERWEIGHT,NORMAL,OVERWEIGHT,
    OBESITY_CLASS_1,OBESITY_CLASS_2, OBESITY_CLASS_3;
    public static Category categoryOfUser(double BMIScore) {
        if(BMIScore<18.5)
            return UNDERWEIGHT;
        if(BMIScore<25)
            return NORMAL;
        if(BMIScore<30)
            return OVERWEIGHT;
        if(BMIScore<35)
            return OBESITY_CLASS_1;
        if(BMIScore<40)
            return OBESITY_CLASS_2;

        return OBESITY_CLASS_3;
    }
    @Override
    public String toString() {
        switch (this) {
            case NORMAL -> {
                return "Normal";
            }
            case OVERWEIGHT -> {
                return "Overweight";
            }
            case UNDERWEIGHT -> {
                return "Underweight";
            }
            case OBESITY_CLASS_1 -> {
                return "Obesity Class 1";
            }
            case OBESITY_CLASS_2 -> {
                return "Obesity Class 2";
            }
            case OBESITY_CLASS_3 -> {
                return "Obesity Class 3";
            }
        }
        return null;
    }
}
