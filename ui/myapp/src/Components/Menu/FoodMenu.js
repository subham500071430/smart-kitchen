import React from 'react';

const Menu = () => {
    const menuItems = [
        { id: 1, name: 'Burger', price: 5.99, description: 'A juicy grilled beef patty with lettuce and tomato.' },
        { id: 2, name: 'Pizza', price: 8.99, description: 'Cheese and pepperoni on a crispy crust.' },
        { id: 3, name: 'Pasta', price: 7.99, description: 'Penne pasta with creamy Alfredo sauce.' },
        { id: 4, name: 'Salad', price: 4.99, description: 'Fresh garden salad with mixed greens and veggies.' },
    ];

    return (
        <div>
            <h2>Menu</h2>
            <ul>
                {menuItems.map(item => (
                    <li key={item.id} style={styles.menuItem}>
                        <h3>{item.name}</h3>
                        <p>{item.description}</p>
                        <p>Price: ${item.price.toFixed(2)}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

const styles = {
    menuItem: {
        border: '1px solid #ccc',
        borderRadius: '5px',
        padding: '10px',
        marginBottom: '10px',
        listStyle: 'none',
    },
};

export default Menu;