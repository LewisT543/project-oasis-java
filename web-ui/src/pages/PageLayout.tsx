import React from 'react';
import {Outlet} from "react-router-dom";

export const PageLayout: React.FC = () => {
  return (
    <div>
      <header>
        <h1>Welcome to My Website</h1>
      </header>

      <main>
        <Outlet />
      </main>

      <footer>
        <p>&copy; 2024 My Website</p>
      </footer>
    </div>
  );
};
