import './App.css'
import {PropertyProvider} from "./api/PropertyProvider.tsx";
import {PropertiesList} from "./components/PropertiesList.tsx";

function App() {
  return (
    <PropertyProvider>
      <PropertiesList />
    </PropertyProvider>
  );
}

export default App
