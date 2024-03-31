import './App.css'
import {PropertiesList} from "./components/PropertiesList.tsx";
import {CombinedProvider} from "./api/CombinedProvider.tsx";
import {ApplicantsList} from "./components/ApplicantsList.tsx";

function App() {
  return (
    <CombinedProvider
      applicantsUrl={import.meta.env.VITE_APPLICANT_API_URL}
      propertyUrl={import.meta.env.VITE_PROPERTY_API_URL}>
      <PropertiesList />
      <ApplicantsList />
    </CombinedProvider>
  );
}

export default App
