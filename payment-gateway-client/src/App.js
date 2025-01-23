// src/App.js

import React, { useState } from 'react';
import axios from 'axios';

function App() {
  const [payment, setPayment] = useState({
    creditCardNumber: '',
    cardHolderName: '',
    expirationDate: '',
    cvv: '',
    amount: ''
  });

  const [transactionId, setTransactionId] = useState('');
  const [status, setStatus] = useState(null);

  const handleChange = (e) => {
    setPayment({ ...payment, [e.target.name]: e.target.value });
  };

  const initiatePayment = () => {
    axios.post('http://localhost:8080/', payment, {
      auth: {
        username: 'admin',
        password: 'admin123'
      }
    })
    .then(response => {
      setTransactionId(response.data.transactionId);
      setStatus(response.data.status);
    })
    .catch(error => {
      console.error(error);
    });
  };

  const checkStatus = () => {
    axios.get(`http://localhost:8080/${transactionId}`, {
      auth: {
        username: 'admin',
        password: 'admin123'
      }
    })
    .then(response => {
      setStatus(response.data.status);
    })
    .catch(error => {
      console.error(error);
    });
  };

  return (
    <div>
      <h1>Payment Gateway</h1>
      <input type="text" name="creditCardNumber" placeholder="Credit Card Number" onChange={handleChange} />
      <input type="text" name="cardHolderName" placeholder="Card Holder Name" onChange={handleChange} />
      <input type="text" name="expirationDate" placeholder="Expiration Date" onChange={handleChange} />
      <input type="text" name="cvv" placeholder="CVV" onChange={handleChange} />
      <input type="number" name="amount" placeholder="Amount" onChange={handleChange} />
      <button onClick={initiatePayment}>Pay Now</button>

      {transactionId && (
        <div>
          <p>Transaction ID: {transactionId}</p>
          <p>Status: {status}</p>
          <button onClick={checkStatus}>Check Status</button>
        </div>
      )}
    </div>
  );
}

export default App;