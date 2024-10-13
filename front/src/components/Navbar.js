import React, { useState } from 'react';

const products = [
    { id: 1, name: 'Produit A' },
    { id: 2, name: 'Produit B' },
    { id: 3, name: 'Produit C' },
];

const Navbar = () => {
    const [isDropdownOpen, setIsDropdownOpen] = useState(false);

    const toggleDropdown = () => {
        setIsDropdownOpen(!isDropdownOpen);
    };

    return (
        <nav style={navStyle}>
            <h1 style={titleStyle}>HRManagement</h1>
            <div>
                <button onClick={toggleDropdown} style={buttonStyle}>
                    Solutions
                </button>
                {isDropdownOpen && (
                    <ul style={dropdownStyle}>
                        {products.map(product => (
                            <li key={product.id} style={itemStyle}>
                                {product.name}
                            </li>
                        ))}
                    </ul>
                )}
            </div>
        </nav>
    );
};

const navStyle = {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    padding: '10px 20px',
    backgroundColor: '#007bff',
    color: 'white',
};

const titleStyle = {
    margin: 0,
};

const buttonStyle = {
    padding: '10px',
    backgroundColor: 'white',
    color: '#007bff',
    border: 'none',
    cursor: 'pointer',
    borderRadius: '5px',
};

const dropdownStyle = {
    position: 'absolute',
    backgroundColor: 'white',
    border: '1px solid #ccc',
    borderRadius: '5px',
    marginTop: '10px',
    zIndex: 1,
};

const itemStyle = {
    padding: '10px 15px',
    cursor: 'pointer',
};

export default Navbar;