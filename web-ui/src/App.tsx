import './App.css'
import {CombinedProvider} from "./api/CombinedProvider.tsx";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {ApplicantsList} from "./components/ApplicantsList.tsx";
import {PageLayout} from "./pages/PageLayout.tsx";
import {PropertiesList} from "./components/PropertiesList.tsx";
import {HomePage} from "./pages/HomePage.tsx";
import {RouteNotFoundPage} from "./pages/RouteNotFoundPage.tsx";

function App() {
  return (
    <BrowserRouter>
      <CombinedProvider
        applicantsUrl={import.meta.env.VITE_APPLICANT_API_URL}
        propertyUrl={import.meta.env.VITE_PROPERTY_API_URL}
      >
        <Routes>
          <Route path={"/"} element={(<PageLayout />)} >
            <Route index element={<HomePage />} />
            <Route path={"properties"} element={<PropertiesList />} />
            <Route path={"applicants"} element={<ApplicantsList />} />
            <Route path={"*"} element={<RouteNotFoundPage />} />
          </Route>
        </Routes>
      </CombinedProvider>
    </BrowserRouter>
  );
}

export default App
