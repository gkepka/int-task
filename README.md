# Getting Started

1. Clone the repo
```
git clone https://github.com/gkepka/int-task.git
```
2. Go to repo directory
```
cd int-task
```
3. Build
```
mvn clean package
```
Now you are ready to take the packaged WAR (located under ./target/simple-webapp.war) and deploy it to a Servlet container of your choice. 

# Usage
Example POST request:

```
{
    "products": [
        {
            "name": "Bread",
            "type": "GRAINS",
            "price": 5
        },
        {
            "name": "Banana",
            "type": "FRUITS",
            "price": 4.4
        },
        {
            "name": "Tomato",
            "type": "VEGETABLES",
            "price": 7
        },
        {
            "name": "Steak",
            "type": "MEAT",
            "price": 50
        },
        {
            "name": "Cheese",
            "type": "DAIRY",
            "price": 20.5
        }
    ]
}
```
Example response:

```
{
    "discounts": [
        "TenPercentDiscount"
    ],
    "entries": [
        {
            "product": {
                "name": "Banana",
                "price": 4.4,
                "type": "FRUITS"
            },
            "quantity": 1,
            "totalPrice": 4.4
        },
        {
            "product": {
                "name": "Tomato",
                "price": 7,
                "type": "VEGETABLES"
            },
            "quantity": 1,
            "totalPrice": 7
        },
        {
            "product": {
                "name": "Steak",
                "price": 50,
                "type": "MEAT"
            },
            "quantity": 1,
            "totalPrice": 50
        },
        {
            "product": {
                "name": "Bread",
                "price": 5,
                "type": "GRAINS"
            },
            "quantity": 1,
            "totalPrice": 5
        },
        {
            "product": {
                "name": "Cheese",
                "price": 20.5,
                "type": "DAIRY"
            },
            "quantity": 1,
            "totalPrice": 20.5
        }
    ],
    "totalPrice": 78.21
}
```
