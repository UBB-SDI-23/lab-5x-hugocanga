from faker import Faker
import random

fake = Faker()

# Generate unique product names
product_names = set()
while len(product_names) < 1000000:  # Generate 1 million unique product names
    product_names.add(fake.word())

# Generate unique customer names and emails
customer_names = set()
customer_emails = set()
while len(customer_names) < 1000000:  # Generate 1 million unique customer names and emails
    customer_names.add(fake.name())
    customer_emails.add(fake.email())

# Generate SQL statements for Products
product_statements = []
product_batch_size = 1000
for _ in range(1000):  # Generate 1000 batches of 1000 records each for Products
    product_values = []
    for _ in range(product_batch_size):
        name = product_names.pop()
        price = round(random.uniform(1, 100), 2)
        values = f"('{name}', {price})"
        product_values.append(values)
    statement = f"INSERT INTO products (name, price) VALUES {','.join(product_values)};"
    product_statements.append(statement)

# Generate SQL statements for Customers
customer_statements = []
customer_batch_size = 1000
for _ in range(1000):  # Generate 1000 batches of 1000 records each for Customers
    customer_values = []
    for _ in range(customer_batch_size):
        name = customer_names.pop()
        email = customer_emails.pop()
        values = f"('{name}', '{email}')"
        customer_values.append(values)
    statement = f"INSERT INTO customers (name, email) VALUES {','.join(customer_values)};"
    customer_statements.append(statement)

# Generate SQL statements for Orders
order_statements = []
order_batch_size = 10000
for _ in range(100):  # Generate 100 batches of 10000 records each for Orders
    order_values = []
    for _ in range(order_batch_size):
        customer_id = random.randint(1, 1000000)  # Assuming 1 million customers
        product_id = random.randint(1, 1000000)  # Assuming 1 million products
        quantity = random.randint(1, 10)
        values = f"({customer_id}, {product_id}, {quantity})"
        order_values.append(values)
    statement = f"INSERT INTO orders (customer_id, product_id, quantity) VALUES {','.join(order_values)};"
    order_statements.append(statement)

# Generate SQL statements for Transactions
transaction_statements = []
transaction_batch_size = 10000
for _ in range(100):  # Generate 100 batches of 10000 records each for Transactions
    transaction_values = []
    for _ in range(transaction_batch_size):
        order_id = random.randint(1, 10000000)  # Assuming 10 million orders
        amount = round(random.uniform(10, 100), 2)
        values = f"({order_id}, {amount})"
        transaction_values.append(values)
    statement = f"INSERT INTO transactions (order_id, amount) VALUES {','.join(transaction_values)};"
    transaction_statements.append(statement)

# Generate SQL statements for the many-to-many relationship
relationship_statements = []
relationship_batch_size = 10000000
for _ in range(10):  # Generate 10 batches of 10 million records each for the many-to-many relationship
    relationship_values = []
    for _ in range(relationship_batch_size):
        order_id = random.randint(1, 10000000)
        product_id = random.randint(1, 1000000)  # Assuming 1 million products
        values = f"({order_id}, {product_id})"
        relationship_values.append(values)
    statement = f"INSERT INTO order_product_relationship (order_id, product_id) VALUES {','.join(relationship_values)};"
    relationship_statements.append(statement)

# Write SQL statements to a file
with open('data.sql', 'w') as f:
    f.write('\n'.join(product_statements))
    f.write('\n')
    f.write('\n'.join(customer_statements))
    f.write('\n')
    f.write('\n'.join(order_statements))
    f.write('\n')
    f.write('\n'.join(transaction_statements))
    f.write('\n')
    f.write('\n'.join(relationship_statements))

print("SQL script generated successfully.")

