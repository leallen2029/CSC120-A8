Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?

House: Not every house needs hasDiningRoom specified and a simple name/address is enough.

House(String name, String address, int nFloors) — drops hasDiningRoom, defaults to false
House(String name, String address) — drops floors and hasDiningRoom, defaults to 1 and false

Library: Most libraries have obvious defaults and you don't always know the floor count.

Library(String name, String address) — drops floors, defaults to 1
Library(String name) — drops address and floors

Cafe: The inventory parameters are a lot to type out every time, so these defaults seemed like simple middle-range numbers.

Cafe(String name, String address, int nFloors) — drops inventory, defaults to 24oz coffee, 100 sugar, 100 cream, 100 cups
Cafe(String name, String address) — drops floors and inventory


- What worked, what didn't, what advice would you give someone taking this course in the future? I tried initally to keep all of my kudos project in CampusMap.java but I realised that to seperate the methods of each class it would be smoother if I Override in the Cafe, Building, and Library classes to call different methods, like to be able to get coffee in the cafe.  
