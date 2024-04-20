import React, {useContext} from "react";

export const useSafeContext = <T>(contextObj: React.Context<T>) => (): T => {
  const context = useContext<T>(contextObj)
  if (!useContext<T>(contextObj)) throw new Error(`UseContext must be used within the appropriate Provider`)
  return context
};