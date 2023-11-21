package com.example.moviecatalogservice.model;
import com.example.moviecatalogservice.model.CatalogItem;
public class CatalogItem {
        private String Name;
        private String Desc;
        private int Rating;

        public CatalogItem() {

        }

        public CatalogItem(String name, String desc, int rating) {
         this.Name = name;
         this.Desc = desc;
         this.Rating = rating;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getDesc() {
            return Desc;
        }

        public void setDesc(String desc) {
            Desc = desc;
        }

        public int getRating() {
            return Rating;
        }

        public void setRating(int rating) {
            Rating = rating;
        }
    }

