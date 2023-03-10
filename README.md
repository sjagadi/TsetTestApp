# Selenium Assignment

# Tester Challenge

**Background:** In order to calculate the total cost of a part it is necessary to understand the pricing structure of the underlying material. How a material is priced depends on negotiations with suppliers, and is broken down into multiple “price components”. The amount of these components varies, and the sum of all components will define the final price.
In order to cover this use case, we need a form that allows adding new /removing existing price component fields, where the sum of the price component values is displayed as a total price.

**Goals:**
1. Setup Selenium test framework, using Java
2. Implement Test Case against provided Vue app

## Testcase
## Testdata
1. Price components
   1. Alloy surcharge: 2.15
   2. Scrap surcharge: 3.14
   3. Internal surcharge: 0.7658
   4. External surcharge: 1
   5. Storage surcharge: 0.3

## Testflow
1. Change Base Price value to 5
   1. Hover row
   2. Click on ‘Pencil’ icon
   3. Click on value input (right)
   4. Enter new value
   5. Click on ‘Check’ icon
   6. Verify Expected Results **A**.
2. Add all price components from Testdata
   1. Click on label input (left)
   2. Enter new label
   3. Click on value input (right)
   4. Enter new value
   5. Click on ‘Check’ icon
   6. Verify Expected Results **B**.
3. Remove price component: Internal surcharge
   1. Hover row
   2. Click on ‘Trash’ icon
   3. Verify Expected Results **A**.
4. Edit price component: Storage surcharge
   1. Hover row
   2. Click on ‘Pencil’ icon
   3. Enter new label: ‘T’
   4. Click on ‘Check’ icon
   5. Verify Expected Results **C**.
5. Edit price component: Scrap surcharge
   1. Hover row
   2. Click on ‘Pencil’ icon
   3. Enter new value: -2.15
   4. Click on ‘Check’ icon
   5. Verify Expected Results **D**.
6. Edit price component: Alloy surcharge
   1. Hover row
   2. Click on ‘Pencil’ icon
   3. Enter new value: 1.79
   4. Click on ‘Check’ icon
   5. Verify Expected Results **A**.

## Expected Results

**A. Displayed sum shows correct sum**  
**B. Displayed values of price components are rounded correctly**
   1. Values always show 1 or 2 decimal digits
   2. If value has no decimal digits, show a 0 as decimal digit
   3. If value has more than 2 decimal digits, round to 2 decimal digits

**C. Label input validation**
   1. Labels have to contain at least 2 characters
   2. If input is invalid, restore last valid state 

**D. Value input validation**
   1. Values cannot be negative
   2. If input is invalid, restore last valid state


## Application installation
### Install node
https://nodejs.org/en/
### Clone the [repo](https://github.com/sjagadi/tset-tester-challenge.git)
```
$ git clone git@github.com:sjagadi/tset-tester-challenge.git
```
### Setup and run the test app
``` bash
# Go to the repo
$ cd tset-tester-challenge

# Intall yarn
$ npm install --global yarn

# Install dependencies
$ yarn install --frozen-lockfile

# Run the test app (http://localhost:3000)
$ yarn dev
```
