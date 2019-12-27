public class HungryCats{

    private int TIME = 0;

    public void main(String[] args) {

        Cat[] cat = new Cat[4];
        cat[0] = new Cat("White", 150, 3);
        cat[1] = new Cat("Black", 100, 4);
        cat[2] = new Cat("Fat", 50, 1);
        cat[3] = new Cat("Modest", 20, 2);

        Bowl bowl = new Bowl(800);
        System.out.println(new StringBuilder().append("There are  four cats over there ").append(cat[0].getName()).append(" , ").append(cat[1].getName()).append(" , ").append(cat[2].getName()).append(" and ").append(cat[3].getName()).append(". They are always hungry but they have their own meal schedule:  ").append(cat[0].getSaturationTime()).append(" , ").append(cat[1].getSaturationTime()).append(" ,").append(cat[2].getSaturationTime()).append(" and ").append(cat[3].getSaturationTime()).append("Let see who of them are more voracious. We put %s%n").append(bowl.addFood()).append(" grams into the bowl. Let's observe.").toString());

        do {
            for (Cat i : cat) {

                if (i.getSaturation() == 0) {

                    if (!bowl.checkBowl(i.getAppetite())) {
                        bowl.addFood();
                    }

                    i.eat(bowl);
                    System.out.println(i.getName() + " ate " + i.getAppetite() + " gramms and bacomes hungry  from " + (i.getSaturation()) + " hours");

                    i.setSaturation(i.getSaturation() - 1);
                }
                System.out.printf("Already %d hours have passed %s grams remain in the bowl", TIME, bowl.addFood());

                var i1 = TIME++;
            }
        }
            while (TIME <= 24) ;
    }
}



    class Bowl {

        private static int food;



        Bowl(int food) {
            this.food = food;
        }

        static void  addFood(int n) {
            food -= n;
        }

        Object addFood() {
            this.food += 400;
            System.out.println("We added 400 gramms into the bowl");
            return null;
        }

        boolean checkBowl(int n) {
            return (food - n) >= 0;
        }


    }

    class Cat {

        private String name;
        private int appetite;
        private int saturationTime;
        private int saturation;

        public Cat(String name, int i, int i1) {

            this.name = name;
            this.appetite = appetite;
            this.saturationTime = saturationTime;
            this.saturation = 0;

        }

        String getName() {
            return name;
        }

        int getAppetite() {
            return appetite;
        }

        void setSaturation(int i) {
            this.saturation = saturation;

        }

        int getSaturation() {
            return saturation;
        }


        int getSaturationTime() {
            return saturationTime;


        }


        public void eat(Bowl bowl) {
            Bowl.addFood(appetite);
            saturation += saturationTime;
        }
    }