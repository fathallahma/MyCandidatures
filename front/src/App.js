import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import { Provider } from 'react-redux';
import { store } from './store/Store';
import Login from './components/authentification/Login';
import Home from './components/pages/Home';

export default function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  return (
    <Provider store={store}>
      <Router>
        <Routes>
          <Route
              path = "/"
              element = {isAuthenticated ? <Navigate to="/home" /> : <Login onLogin={() => setIsAuthenticated(true)} />}
          />
          <Route path="/home" element={isAuthenticated ? <Home /> : <Navigate to="/" />} />
        </Routes>
      </Router>
    </Provider>
  );
}
