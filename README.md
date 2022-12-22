Assignment: https://docs.google.com/document/d/1iiQmhuTJtik5pc3MgGsUqMA2HdjDoQ8sZetK_EwxXu0/edit
Application: https://github.com/tsetweb/tset-tester-challenge

# Tset Assignment using Selenium, Java and page object model

# Tester Challenge

Background:
In order to calculate the total cost of a part it is necessary to understand the pricing structure of the underlying material. How a material is priced depends on negotiations with suppliers, and is broken down into multiple “price components”. The amount of these components varies, and the sum of all components will define the final price.
In order to cover this use case, we need a form that allows adding new /removing existing price component fields, where the sum of the price component values is displayed as a total price.

Goals:
Setup Selenium test framework, using Java
Implement Test Case against provided Vue app

# Testcase
# Testdata
1 Price components
  a Alloy surcharge: 2.15
  b Scrap surcharge: 3.14
  c Internal surcharge: 0.7658
  d External surcharge: 1
  e Storage surcharge: 0.3
Testflow
Change Base Price value to 5
Hover row
Click on ‘Pencil’ icon
Click on value input (right)
Enter new value
Click on ‘Check’ icon
Verify Expected Results A.
Add all price components from Testdata
Click on label input (left)
Enter new label
Click on value input (right)
Enter new value
Click on ‘Check’ icon
Verify Expected Results B.
Remove price component: Internal surcharge
Hover row
Click on ‘Trash’ icon
Verify Expected Results A.
Edit price component: Storage surcharge
Hover row
Click on ‘Pencil’ icon
Enter new label: ‘T’
Click on ‘Check’ icon
Verify Expected Results C.
Edit price component: Scrap surcharge
Hover row
Click on ‘Pencil’ icon
Enter new value: -2.15
Click on ‘Check’ icon
Verify Expected Results D.
Edit price component: Alloy surcharge
Hover row
Click on ‘Pencil’ icon
Enter new value: 1.79
Click on ‘Check’ icon
Verify Expected Results A.

Expected Results
Displayed sum shows correct sum
Displayed values of price components are rounded correctly
Values always show 1 or 2 decimal digits
If value has no decimal digits, show a 0 as decimal digit
If value has more than 2 decimal digits, round to 2 decimal digits
Label input validation
Labels have to contain at least 2 characters
If input is invalid, restore last valid state
Value input validation
Values cannot be negative
If input is invalid, restore last valid state
