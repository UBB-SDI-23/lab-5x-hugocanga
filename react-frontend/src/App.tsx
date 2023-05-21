import "./App.css";
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import CustomerDetails from './components/Customer/CustomerDetails';
import { CustomerList } from './components/Customer/CustomerList';
import OrderDetails from './components/Order/OrderDetails';
import OrderList from './components/Order/OrderList';
import Orders from './components/Order/Orders';
import AddProduct from './components/Product/AddProduct';
import EditProduct from './components/Product/EditProduct';
import ProductDetails from './components/Product/ProductDetails';
import ProductList from './components/Product/ProductList';
import TransactionList from './components/Transaction/TransactionList';
import TransactionDetails from './components/Transaction/ransactionDetails';
import { AppMenu } from './components/AppMenu';
import { AppHome } from './components/AppHome';



function App() {
  return (
    <React.Fragment>
    <Router>
      <AppMenu />
        <Routes>
          <Route path="/" element={<AppHome />} />
          <Route path="/products" element={<ProductList />} />
          <Route path="/products/:id" element={<ProductDetails />} />
          <Route path="/addProduct" element={<AddProduct />} />
          <Route path="/editProduct/:id" element={<EditProduct />} />
          <Route path="/customers" element={<CustomerList />} />
          <Route path="/customers/:id" element={<CustomerDetails />} />
          <Route path="/orders" element={<OrderList />} />
          <Route path="/orders/:id" element={<OrderDetails />} />
          <Route path="/transactions" element={<TransactionList />} />
          <Route path="/transactions/:id" element={<TransactionDetails />} />
        </Routes>
    </Router>
    </React.Fragment>
  );
}

export default App;
