import React from 'react';
import { Modal, Button } from 'react-bootstrap';

const CheckoutPopup = ({ show, handleClose, cartItems, totalPrice, handleCheckout }) => {
  return (
    <div className="checkoutPopup">
      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Checkout</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <div className="checkout-items">
            {cartItems.map((item) => (
              <div key={item.id} className="checkout-item" style={{ display: 'flex', marginBottom: '10px' }}>
                <img 
                  src={item.imageUrl} 
                  alt={item.name} 
                  className="cart-item-image" 
                  style={{ width: '150px', marginRight: '10px' }} 
                />
                <div>
                  <b><p>{item.name}</p></b>
                  <p>Brand: {item.brand}</p>
                  <p>Quantity: {item.quantity}</p>
                  <p>Price: ${item.price.toFixed(2)}</p>
                </div>
              </div>
            ))}
            <div style={{ textAlign: 'center' }}>
              <h5 style={{ color: 'black', fontSize: '1.5rem', fontWeight: 'bold' }}>
                Total: ${totalPrice.toFixed(2)}
              </h5>
            </div>
          </div>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={handleCheckout}>
            Confirm Purchase
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
};

export default CheckoutPopup;
