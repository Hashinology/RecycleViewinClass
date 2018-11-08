package com.example.hashi.recycleviewinclass;

import java.io.Serializable;

public class Food implements Serializable
    {
        private String dishName;
        private int price;
        private int calories;
        private double ratings;

        public Food(String dishName, int price, int calories, double ratings) {
            this.dishName = dishName;
            this.price = price;
            this.calories = calories;
            this.ratings = ratings;
        }

        public String getDishName() { return dishName;    }

        public void setDishName(String dishName) { this.dishName = dishName;   }

        public int getPrice() { return price;    }

        public void setPrice(int price) { this.price = price;    }

        public int getCalories() { return calories;    }

        public void setCalories(int calories) { this.calories = calories;   }

        public double getRatings() { return ratings;    }

        public void setRatings(double ratings) {
            this.ratings = ratings;
        }

        @Override
        public String toString() {
            return "Food{" +
                    "dishName='" + dishName + '\'' +
                    ", price=" + price +
                    ", calories=" + calories +
                    ", ratings=" + ratings +
                    '}';
        }

    }
