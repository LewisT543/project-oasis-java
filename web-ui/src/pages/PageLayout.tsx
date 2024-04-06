import React from 'react';
import {Outlet} from "react-router-dom";
import {Header} from "@/custom-components/fragments.tsx"

export const PageLayout: React.FC = () => {
  return (
    <>
      <Header />
      <main>
        <Outlet />
      </main>
    </>
  );
};
