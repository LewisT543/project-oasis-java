import React, {ReactNode} from "react";

type RouteNotFoundPageProps = {
  children?: ReactNode;
}

export const RouteNotFoundPage: React.FC<RouteNotFoundPageProps> = ({ children }) => {
  return (
    <div>
      <h1>Route Not Found</h1>
      <div>
        {children}
      </div>
    </div>
  )
}