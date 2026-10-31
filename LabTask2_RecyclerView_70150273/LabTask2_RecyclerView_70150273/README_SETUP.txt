UOL Food Court Menu - MAD Lab Task 02 (RecyclerView)
Name: Hammad Ali | SAP ID: 70150273 | Section: T
Package: com.uol.foodcourt

HOW TO OPEN AND RUN
1. Open Android Studio > Open > select this folder (LabTask2_RecyclerView_70150273).
2. Wait for Gradle sync to finish. Internet is needed the first time to
   download androidx.recyclerview:recyclerview:1.3.2 and
   androidx.cardview:cardview:1.0.0 (already added in app/build.gradle).
3. Run the app on an emulator or a real phone with the green Run button.

WHAT IS INSIDE
- Dish.java              - model class (name, category, description, stallPhone, price, imageResId + getters)
- DishAdapter.java       - RecyclerView.Adapter, static ViewHolder, OnItemClickListener interface
- MainActivity.java      - 8 dishes, GridLayoutManager span 2, rvMenu, onItemClick() with explicit Intent
- DishDetailActivity.java- reads extras, shows the tapped dish, Call to Order with ACTION_DIAL in try-catch
- item_dish.xml          - CardView (cardCornerRadius + cardElevation), ImageView + 2 TextViews
- activity_main.xml      - RecyclerView with id rvMenu
- activity_dish_detail.xml - image, name, category, price, description, Call to Order button
- res/drawable/dish_*.png - 8 dish images

GITHUB STEPS
1. On github.com create a NEW PUBLIC repository named exactly:
   LabTask2_RecyclerView_70150273
   Do not add README / .gitignore in the web form.
2. In Android Studio: VCS > Enable Version Control Integration > Git.
   Or use Git Bash in this folder:
     git init
     git add .
     git commit -m "Lab Task 2 RecyclerView - UOL Food Court Menu"
     git branch -M main
     git remote add origin https://github.com/<your-username>/LabTask2_RecyclerView_70150273.git
     git push -u origin main
3. Copy your repository link and write it on the first page of the report.
4. Commit again after any change so the commit history shows regular work.

SLATE SUBMISSION
- Upload the report PDF and this project exported as ZIP
  (in Android Studio: File > Export > Export to Zip File).
