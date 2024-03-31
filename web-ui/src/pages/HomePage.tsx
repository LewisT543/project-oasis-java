import React, {ReactNode} from "react";

type HomePageProps = {
  children?: ReactNode;
}

export const HomePage: React.FC<HomePageProps> = ({ children }) => {
  return (
    <div>
      <h1>HOMEPAGE</h1>
      <div>
        {children}
      </div>
    </div>
  )
}