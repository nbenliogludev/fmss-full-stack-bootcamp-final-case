import React from 'react';

interface AuthButtonProps extends React.ButtonHTMLAttributes<HTMLButtonElement> {
    children?: React.ReactNode;
    className?: string;
}

const AuthButton: React.FC<AuthButtonProps> = ({
    type = 'button',
    children,
    className = '',
    ...rest
}) => {
    return (
        <button
            type={type}
            className={`flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600 ${className}`}
            {...rest}
        >
            {children}
        </button>
    );
};

export default AuthButton;
