import {
    Box,
    AppBar,
    Toolbar,
    IconButton,
    Typography,
    Button,
  } from "@mui/material";
  import { Link, useLocation } from "react-router-dom";
  import InventoryIcon from '@mui/icons-material/Inventory';
  import ShopIcon from '@mui/icons-material/Shop';
  
  export const AppMenu = () => {
    const location = useLocation();
    const path = location.pathname;
  
    return (
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static" sx={{ marginBottom: "20px" }}>
          <Toolbar>
            <IconButton
              component={Link}
              to="/"
              size="large"
              edge="start"
              color="inherit"
              aria-label="school"
              sx={{ mr: 2 }}
            >
              <ShopIcon />
            </IconButton>
  
            <Typography variant="h6" component="div" sx={{ mr: 5 }}>
              Shop management
            </Typography>
  
            <Button
              variant={path.startsWith("/products") ? "outlined" : "text"}
              to="/products"
              component={Link}
              color="inherit"
              sx={{ mr: 5 }}
              startIcon={<InventoryIcon />}
            >
              Products
            </Button>
            <Button
              variant={path.startsWith("/addProduct") ? "outlined" : "text"}
              to="/addProduct"
              component={Link}
              color="inherit"
              sx={{ mr: 5 }}
              startIcon={<InventoryIcon />}
            >
              Add Product
            </Button>
            <Button
              variant={path.startsWith("/customers") ? "outlined" : "text"}
              to="/customers"
              component={Link}
              color="inherit"
              sx={{ mr: 5 }}
              startIcon={<InventoryIcon />}
            >
              Customers
            </Button>
  
            <Button
              variant={
                path.startsWith("/orders")
                  ? "outlined"
                  : "text"
              }
              to="/orders"
              component={Link}
              color="inherit"
              sx={{ mr: 5 }}
              startIcon={<InventoryIcon />}
            >
              Orders  
            </Button>
  
            <Button
              variant={path.startsWith("/transactions") ? "outlined" : "text"}
              to="/transactions"
              component={Link}
              color="inherit"
              sx={{ mr: 5 }}
              startIcon={<InventoryIcon />}
            >
              Transactions
            </Button>
          </Toolbar>
        </AppBar>
      </Box>
    );
  };