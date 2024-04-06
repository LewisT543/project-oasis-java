import {
  NavigationMenu,
  NavigationMenuItem,
  NavigationMenuList,
  NavigationMenuTrigger
} from "@/components/ui/navigation-menu.tsx";
import React from "react";
import {Link} from "react-router-dom";
import {ROUTES} from "@/pages/routes.ts";

export const Header = () => {
  return (
    <header className="m-4">
      <TitleBar />
      <NavBar />
    </header>
  )
}

export const TitleBar = () => {
  return (
    <div className="flex items-center justify-center m-5">
      <h1>Hoos</h1>
    </div>
  )
}

// Change this to have individual Link Items and store the values in an object in routes
const NavigationMenuItemWithLink: React.FC<{ linkText: string, path: string }> = ({ linkText, path }) => {
  return (
    <NavigationMenuItem>
      <Link to={path}>
        <NavigationMenuTrigger>
          <h2>{linkText}</h2>
        </NavigationMenuTrigger>
      </Link>
    </NavigationMenuItem>
  )
}

export const NavBar = () => {
  return (
    <div className="flex items-top justify-center">
      <NavigationMenu>
        <NavigationMenuList className="">
          <NavigationMenuItemWithLink linkText="Go to Homepage" path={ROUTES.root} />
          <NavigationMenuItemWithLink linkText="Applicants" path={ROUTES.applicants.HOME} />
          <NavigationMenuItemWithLink linkText="Properties" path={ROUTES.properties.HOME} />
        </NavigationMenuList>
      </NavigationMenu>
    </div>
  )
}

export const Footer = () => {
  return (
    <footer className='absolute flex bottom-5 justify-center w-full'>
      <div>&copy; 2024 My Website</div>
    </footer>
  )
}

